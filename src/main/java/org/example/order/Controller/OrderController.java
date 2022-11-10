package org.example.order.Controller;

import org.example.order.Entity.Order;
import org.example.order.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/naver/pay")
public class OrderController {
    OrderService orderService = new OrderService();

    //TODO : 네이버 페이 접근
    // 1. 로그인 확인
    // 2 - 1). 로그인 상태라면 네이버 페이 홈 이동
    // 2 - 2). 로그인 상태가 아니라면 로그인 페이지로 이동

    //TODO : 쇼핑 리스트 가져오기
    @GetMapping("/order") //URL 매핑
    public String getAllList(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(); //세션 불러오기

        if(session.getAttribute("userNum") == null) {
            System.out.println("error : session is null");
            return "index";
        }
        else {
            int userNum = (Integer) session.getAttribute("userNum");   //세션에서 userNum 받아오기
            List<Order> orderList = orderService.getAllList(userNum);   //서비스 호출해서 값 받아오기
            model.addAttribute("list", orderList);  //모델 생성해서 리스트 넣어주기
            return "/order/paylist";   //View 호출하기
        }

    }

/*    //TODO : 쇼핑 리스트 기간 검색(현재 날짜 기준 n일)
    // localhost:8080/naver/gettermlist/?term=7
    @GetMapping("/search") //URL 매핑
    public String gettermList(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(); //세션 불러오기
        int term = Integer.parseInt(request.getParameter("term"));  //클라이언트에게 들어온 기간 받아오기
        int userNum = (Integer) session.getAttribute("userNum");   //세션에서 userNum 받아오기
        List<Order> orderList = orderService.getPeriodList(userNum, term);   //서비스 호출해서 값 받아오기
        model.addAttribute("list", orderList);  //모델 생성해서 리스트 넣어주기
        return "/order/paylist";   //View 호출하기
    }
    // 1. 세션 불러오기
    // 2. 세션에서 userNum 받아오기
    // 3. 클라이언트에게 들어온 기간 받아오기
    // 4. 서비스 호출해서 값 받아오기 orderService.getperiodList(userNum, period)
    // 5. 모델 생성해서 리스트 넣어주기
    // 6. View 호출하기*/

    //TODO : 쇼핑 리스트 기간 검색(시작 날짜와 끝나는 날짜 선택)
    @GetMapping("/search") //URL 매핑
    public String getperiodList(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(); //세션 불러오기
        if(session.getAttribute("userNum") == null) {
            System.out.println("error");
            return "/order/paylist";
        }
        else {
            int userNum = (Integer) session.getAttribute("userNum");   //세션에서 userNum 받아오기
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            System.out.println(userNum);
            System.out.println(startDate);
            System.out.println(endDate);
            List<Order> orderList = orderService.getPeriodList(userNum, startDate, endDate);
            model.addAttribute("list", orderList);
            return "/order/paylist";
        }
    }
    // localhost:8080/naver/getperiodList/?startdate=2022-10-07&enddate=2022-10-13
    // 1. 세션 불러오기
    // 2. 세션에서 userNum 받아오기
    // 3. 클라이언트에게 들어온 기간 받아오기
    // 4. 서비스 호출해서 값 받아오기 orderService.getperiodList(userNum, startDate, endDate)
    // 5. 모델 생성해서 리스트 넣어주기
    // 6. View 호출하기
}
