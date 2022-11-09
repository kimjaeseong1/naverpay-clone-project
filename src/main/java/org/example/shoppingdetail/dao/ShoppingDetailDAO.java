package org.example.shoppingdetail.dao;

import org.example.database.JDBCMgr;
import org.example.order.Entity.OrderStatus;
import org.example.shoppingdetail.entity.PaymentMethod;
import org.example.shoppingdetail.entity.ShoppingDetail;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ShoppingDetailDAO implements IShoppingDetailDAO{
    private static ShoppingDetailDAO shoppingDetailDAO = null;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public static ShoppingDetailDAO getInstance() {
        if (shoppingDetailDAO == null) {
            shoppingDetailDAO = new ShoppingDetailDAO();
        }
        return shoppingDetailDAO;
    }

    @Override
    public ShoppingDetail select(int id) {
        ShoppingDetail shoppingDetail = new ShoppingDetail();
        try {
            conn = JDBCMgr.getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT p.paymentid, p.ordercount, p.deliveryprice, p.totalprice, p.paymentmethod, p.productprice, o.orderdate, o.ordername, o.storename, o.storephone, o.orderstatus ");
            sb.append("FROM	paymentinfo p, orderinfo o ");
            sb.append("WHERE p.paymentid = o.paymentid and p.paymentid = ?");
            stmt = conn.prepareStatement(sb.toString());
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                shoppingDetail.setPaymentId(rs.getInt("paymentid"));
                shoppingDetail.setOrderCount(rs.getInt("ordercount"));
                shoppingDetail.setDeliveryPrice(rs.getInt("deliveryprice"));
                shoppingDetail.setTotalPrice(rs.getInt("totalprice"));
                shoppingDetail.setOrderDate(rs.getString("orderdate"));
                shoppingDetail.setOrderName(rs.getString("ordername"));
                shoppingDetail.setProductPrice(rs.getInt("productprice"));
                shoppingDetail.setStoreName(rs.getString("storename"));
                shoppingDetail.setStorePhone(rs.getString("storephone"));
                shoppingDetail.setOrderStatus(OrderStatus.valueOf(rs.getString("orderstatus").replace(" ", "_")));
                shoppingDetail.setPaymentMethod(PaymentMethod.valueOf(rs.getString("paymentmethod").replace(" ", "_")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return shoppingDetail;
    }

    @Override
    public int delete(int id) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();

            String orderDeleteQuery = "delete orderinfo where paymentid = ?";
            String paymentDeleteQuery = "delete paymentinfo where paymentid = ?";

            stmt = conn.prepareStatement(orderDeleteQuery);
            stmt.setInt(1, id);
            res = stmt.executeUpdate();

            stmt = conn.prepareStatement(paymentDeleteQuery);
            stmt.setInt(1, id);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return res;
    }
}
