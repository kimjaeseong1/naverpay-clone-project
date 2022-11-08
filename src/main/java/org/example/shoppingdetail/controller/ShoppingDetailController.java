package org.example.shoppingdetail.controller;

import org.example.shoppingdetail.dto.ShoppingDetailDTO;
import org.example.shoppingdetail.service.ShoppingDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/naver")
public class ShoppingDetailController {
    private ShoppingDetailService shoppingDetailService = ShoppingDetailService.getInstance();

    /**
     * 쇼핑 상세 페이지 접근
     */
    @GetMapping("/detail")
    public String shoppingDetailPage(Model model, @RequestParam int paymentId) {
//        if (paymentId < 1) {
//            return
//        }
        ShoppingDetailDTO shoppingDetailDTO = shoppingDetailService.getShoppingDetailByPaymentId(paymentId);

        model.addAttribute(shoppingDetailDTO);

        return "shoppingdetail";
    }

    /**
     * 쇼핑 상세 리스트 반환
     */


    /**
     * 쇼핑 상세 리스트 삭제
     */
}
