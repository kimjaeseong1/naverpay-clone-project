package org.example.order.DAO;

import org.example.database.JDBCMgr;
import org.example.order.Entity.Order;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAO implements IOrderDAO{
    private static OrderDAO orderDAO = null;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String SELECT_LIST = "select * from orderinfo where userNum = ?";
    private static final String SELECT_PERIOD_LIST = "select * from orderinfo where userNum = ? AND ORDERDATE >= ? AND ORDERDATE <= ?";

    public static OrderDAO getInstance() {
        if (orderDAO == null) {
            orderDAO = new OrderDAO();
        }
        return orderDAO;
    }

    @Override
    public List<Order> getAllList(int userNum) {
        List<Order> orderList = new ArrayList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SELECT_LIST);
            stmt.setString(1, String.valueOf(userNum));

            rs = stmt.executeQuery();
            while (rs.next()) {
                //TODO : 자료형 맞게 가져와서 Order의 생성자에 넣어주세요.
                int OrderID = rs.getInt("ORDERID");
                int usernum = rs.getInt("USERNUM");
                int paymentID = rs.getInt("PAYMENTID");
                String orderName = rs.getString("ORDERNAME");
                String orderDate = rs.getString("ORDERDATE");
                String orderStatus = rs.getString("ORDERSTATUS");
                String storeName = rs.getString("STORENAME");
                String storePhone = rs.getString("STOREPHONE");
                orderList.add(new Order(OrderID, usernum, paymentID, orderName, orderDate, orderStatus, storeName, storePhone));
                /* 예시)
                String mId = rs.getString("uId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");

                orderList.add(new Member(mId, uPw, uEmail));
                */
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            JDBCMgr.close(rs, stmt, conn);
        }
        return orderList;
    }

    @Override
    public List<Order> getPeriodList(int userNum, String startDate, String endDate) {
        List<Order> orderList = new ArrayList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SELECT_PERIOD_LIST);
            stmt.setString(1, String.valueOf(userNum));
            stmt.setString(2, startDate);
            stmt.setString(3, endDate);
            rs = stmt.executeQuery();
            String q = stmt.toString();
            while (rs.next()) {

                //TODO : 자료형 맞게 가져와서 Order의 생성자에 넣어주세요.
                int OrderID = rs.getInt("ORDERID");
                int usernum = rs.getInt("USERNUM");
                int paymentID = rs.getInt("PAYMENTID");
                String orderName = rs.getString("ORDERNAME");
                String orderDate = rs.getString("ORDERDATE");
                String orderStatus = rs.getString("ORDERSTATUS");
                String storeName = rs.getString("STORENAME");
                String storePhone = rs.getString("STOREPHONE");
                orderList.add(new Order(OrderID, usernum, paymentID, orderName, orderDate, orderStatus, storeName, storePhone));
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            JDBCMgr.close(rs, stmt, conn);
        }
        return orderList;
    }
}
