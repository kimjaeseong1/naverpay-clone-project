package org.example.shoppingdetail;

import org.example.order.Entity.OrderStatus;
import org.example.shoppingdetail.dao.ShoppingDetailDAO;

public class Test {
    public static void main(String[] args) {
        ShoppingDetailDAO dao = ShoppingDetailDAO.getInstance();

        System.out.println(dao.select(1));
        dao.delete(1);
    }
}
