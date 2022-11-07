package org.example.order.Entity;

public class Order {

    enum OrderStatus {결제_완료, 상품_준비_중, 배송_중, 배송_완료, 구매_확정, 환불_신청, 환불_환료, 교환_신청, 교환_완료}
    int orderID;    //주문 번호
    int userNum;    //고객 번호
    int paymentID;  //주문 결제 번호
    String orderName;   //상품 이름
    String orderDate;   //주문 일자
    OrderStatus orderStatus;   //결제 상태
    String storeName;   //판매자 이름
    String storePhone;  //판매자 전화번호

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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
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
