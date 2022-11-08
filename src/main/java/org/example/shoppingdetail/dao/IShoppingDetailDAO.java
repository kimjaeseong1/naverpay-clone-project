package org.example.shoppingdetail.dao;

import org.example.shoppingdetail.entity.ShoppingDetail;

public interface IShoppingDetailDAO {

    ShoppingDetail select(int id);
    int delete(int id);
}
