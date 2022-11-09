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

        if (session.getAttribute("SESSION_ID") != null) {
            return "redirect:/";
        }

        String autoLogin = cookieMgr.get(request,"AUTO_LOGIN");
        String cookieId = cookieMgr.get(request,"COOKIE_ID");

        if (autoLogin != null || cookieId != null) {
            if (memberService.autoLogin(autoLogin, cookieId)) {
                sessionMgr.create(session, cookieId);
                view = "redirect:/";
            }
        }

        return view;
    }

    @PostMapping("/login")
    public String dologin (@RequestParam String USERID,
                           @RequestParam String USERPWD,
                           @RequestParam(required = false) String save,
                           Model model, HttpServletRequest request,
                           HttpSession session,
                           HttpServletResponse response) {
        String view = loginPage(request, session);
        Status respStatus = Status.FAIL;

        MemberDTO memberDTO = memberService.login(USERID, USERPWD);
        if (memberDTO != null) {
            sessionMgr.create(session, USERID);

            saveCookieForAutoLogin(USERID,save,response);
            
            view = "redirect:/";
            respStatus = Status.SUCCESS;
        }


        session.setAttribute("login",respStatus);
        session.setAttribute("userNum", memberDTO.getUSERNUM());
        model.addAttribute("USERID", session.getAttribute("SESSION_ID"));
        return view;
    }

    private void saveCookieForAutoLogin(String USERID, String save, HttpServletResponse response) {
        if (save == null) return;

        if (save.equals("on")) {
            cookieMgr.create(response, new String[] {USERID, "true"});
        }
    }
}
