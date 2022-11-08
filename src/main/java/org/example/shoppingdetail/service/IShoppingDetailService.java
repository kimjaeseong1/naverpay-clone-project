package org.example.shoppingdetail.service;

import org.example.shoppingdetail.entity.ShoppingDetail;

public interface IShoppingDetailService {

    ShoppingDetail getShoppingDetailByPaymentId(int id);

    int deleteShoppingDetailByPaymentId(int id);
}
