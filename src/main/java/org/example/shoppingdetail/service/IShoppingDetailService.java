package org.example.shoppingdetail.service;

import org.example.shoppingdetail.dto.ShoppingDetailDTO;

public interface IShoppingDetailService {

    ShoppingDetailDTO getShoppingDetailByPaymentId(int id);

    boolean deleteShoppingDetailByPaymentId(int id);
}
