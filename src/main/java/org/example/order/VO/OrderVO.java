package org.example.order.VO;

import org.example.order.Entity.OrderStatus;

public class OrderVO {
    private int orderID;    //주문 번호
    private int userNum;    //고객 번호
    private int paymentID;  //주문 결제 번호
    private String orderName;   //상품 이름
    private String orderDate;   //주문 일자
    private String orderStatus;   //결제 상태
    private String storeName;   //판매자 이름
    private String storePhone;  //판매자 전화번호

    public OrderVO() {}

    public OrderVO(int orderID, int userNum, int paymentID, String orderName, String orderDate, String orderStatus, String storeName, String storePhone) {
        this.orderID = orderID;
        this.userNum = userNum;
        this.paymentID = paymentID;
        this.orderName = orderName;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.storeName = storeName;
        this.storePhone = storePhone;
    }
}
