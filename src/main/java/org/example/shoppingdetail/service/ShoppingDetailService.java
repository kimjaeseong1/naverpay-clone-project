package org.example.shoppingdetail.service;

import org.example.shoppingdetail.dao.ShoppingDetailDAO;
import org.example.shoppingdetail.dto.ShoppingDetailDTO;
import org.example.shoppingdetail.entity.ShoppingDetail;
import org.springframework.stereotype.Service;

@Service
public class ShoppingDetailService implements IShoppingDetailService{

    private ShoppingDetailDAO shoppingDetailDAO = ShoppingDetailDAO.getInstance();
    private static ShoppingDetailService shoppingDetailService = null;

    public static ShoppingDetailService getInstance() {
        if (shoppingDetailService == null) {
            shoppingDetailService = new ShoppingDetailService();
        }
        return shoppingDetailService;
    }

    @Override
    public ShoppingDetailDTO getShoppingDetailByPaymentId(int paymentId) {
        if (paymentId == 0) {
            return null;
        }
        ShoppingDetail shoppingDetail = shoppingDetailDAO.select(paymentId);
        return shoppingDetail.toDTO();
    }

    @Override
    public boolean deleteShoppingDetailByPaymentId(int paymentId) {
        if (paymentId == 0) {
            return false;
        }

        ShoppingDetail shoppingDetail = shoppingDetailDAO.select(paymentId);
        if (shoppingDetail == null) {
            return false;
        }

        int res = shoppingDetailDAO.delete(paymentId);
        return res > 0;
    }
}
