package org.example.order.DTO;

import org.example.order.Entity.Order;
import org.example.order.Entity.OrderStatus;
import org.example.order.VO.OrderVO;

public class OrderDTO {
    private int orderID;    //주문 번호
    private int userNum;    //고객 번호
    private int paymentID;  //주문 결제 번호
    private String orderName;   //상품 이름
    private String orderDate;   //주문 일자
    private String orderStatus;   //결제 상태
    private String storeName;   //판매자 이름
    private String storePhone;  //판매자 전화번호

    public OrderDTO() {}

    public OrderDTO(int orderID, int userNum, int paymentID, String orderName, String orderDate, String orderStatus, String storeName, String storePhone) {
        this.orderID = orderID;
        this.userNum = userNum;
        this.paymentID = paymentID;
        this.orderName = orderName;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.storeName = storeName;
        this.storePhone = storePhone;
    }

    public Order toEntity() {
        return new Order(orderID, userNum, paymentID, orderName, orderDate, orderStatus, storeName, storePhone);
    }

    public OrderVO toVO() {
        return new OrderVO(orderID, userNum, paymentID, orderName, orderDate, orderStatus, storeName, storePhone);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }
}
