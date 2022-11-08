package org.example.shoppingdetail.dto;

import org.example.order.Entity.OrderStatus;
import org.example.shoppingdetail.entity.PaymentMethod;
import org.example.shoppingdetail.entity.ShoppingDetail;

public class ShoppingDetailDTO {

    private int paymentId;
    private String orderName;
    private int orderCount;
    private String orderDate;
    private String storeName;
    private String storePhone;
    private PaymentMethod paymentMethod;
    private OrderStatus orderStatus;
    private int productPrice;
    private int deliveryPrice;
    private int totalPrice;

    public ShoppingDetailDTO(int paymentId, String orderName, int orderCount, String orderDate, String storeName, String storePhone, PaymentMethod paymentMethod, OrderStatus orderStatus, int productPrice, int deliveryPrice, int totalPrice) {
        this.paymentId = paymentId;
        this.orderName = orderName;
        this.orderCount = orderCount;
        this.orderDate = orderDate;
        this.storeName = storeName;
        this.storePhone = storePhone;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
        this.productPrice = productPrice;
        this.deliveryPrice = deliveryPrice;
        this.totalPrice = totalPrice;
    }

    public ShoppingDetail toEntity() {
        return new ShoppingDetail(paymentId, orderName, orderCount, orderDate, storeName, storePhone, paymentMethod, orderStatus, productPrice, deliveryPrice, totalPrice);
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
