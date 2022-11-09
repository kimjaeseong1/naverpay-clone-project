package org.example.shoppingdetail.controller;

import org.example.shoppingdetail.dao.ShoppingDetailDAO;
import org.example.shoppingdetail.dto.ShoppingDetailDTO;
import org.example.shoppingdetail.entity.ShoppingDetail;
import org.example.shoppingdetail.service.ShoppingDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/naver/pay/shopping")
public class ShoppingDetailController {
    private ShoppingDetailService shoppingDetailService = ShoppingDetailService.getInstance();

    /**
     * 쇼핑 상세 페이지 접근
     */
    @GetMapping("/detail")
    public String shoppingDetailPage(Model model, @RequestParam int paymentId) {
        ShoppingDetail shoppingDetail = shoppingDetailService.getShoppingDetailByPaymentId(paymentId).toEntity();
        model.addAttribute("shoppingDetail", shoppingDetail);

//        String paymentMethod = shoppingDetail.getPaymentMethod();
//        model.addAttribute("paymentMethod", shoppingDetail);
//
//
//        model.addAttribute("orderStatus", shoppingDetail);
        return "shoppingdetail/shoppingdetail";
    }

    /**
     * 쇼핑 상세 리스트 삭제
     */
    @PostMapping("/delete")
    public String shoppingDetailDelete(@RequestBody String paymentId) {
        String valueStr = paymentId.substring(10, paymentId.length());
        int value = Integer.parseInt(valueStr);
        boolean isRemoved = shoppingDetailService.deleteShoppingDetailByPaymentId(value);
        return "redirect:/naver/pay/order"; // 주문 리스트로 바꿀 예정
    }

}
