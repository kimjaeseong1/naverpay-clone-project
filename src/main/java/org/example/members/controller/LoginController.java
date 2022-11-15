package org.example.members.controller;

import org.example.cookies.CookieMgr;
import org.example.members.dto.MemberDTO;
import org.example.members.service.MemberService;
import org.example.session.SessionMgr;
import org.example.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class LoginController {
    private CookieMgr cookieMgr;
    private SessionMgr sessionMgr;
    private MemberService memberService;

    @Autowired
    public LoginController(CookieMgr cookieMgr, SessionMgr sessionMgr, MemberService memberService) {
        this.cookieMgr = cookieMgr;
        this.sessionMgr = sessionMgr;
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, HttpSession session) {
        String view = "/members/login";

        if (session.getAttribute("SESSION_ID") != null) { //세션아이디 있으면 홈으로 이동
            return "redirect:/";
        }

        String cookieId = cookieMgr.get(request,"COOKIE_ID");

        if (cookieId != null) {
            sessionMgr.create(session, cookieId);
            view = "redirect:/";
        }

        return view;
    }

    @PostMapping("/login")
    public String dologin (@RequestParam String USERID,
                           @RequestParam String USERPWD,
                           Model model, HttpServletRequest request,
                           HttpSession session,
                           HttpServletResponse response) {
        String view = loginPage(request, session);
        Status respStatus = Status.FAIL;

        MemberDTO memberDTO = memberService.login(USERID, USERPWD); //로그인 시도
        if (memberDTO != null) { //로그인 성공하면
            sessionMgr.create(session, USERID); // 유저아이디를 value 값으로 세션 생성
            session.setAttribute("userNum", memberDTO.getUSERNUM()); //userNum 전달 위해서 받아와서 세션에 저장
            view = "redirect:/"; //홈으로 이동
            respStatus = Status.SUCCESS; //로그인 성공으로 상태변경
        }

        session.setAttribute("login",respStatus);
        model.addAttribute("USERID", session.getAttribute("SESSION_ID"));
        return view;
    }
}
