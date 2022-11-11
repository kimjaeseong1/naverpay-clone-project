package org.example.shoppingdetail.entity;

public class Payment {
    private int paymentId;
    private int productPrice;
    private int deliveryPrice;
    private int totalPrice;
    private PaymentMethod paymentMethod;

    public Payment(int paymentId, int productPrice, int deliveryPrice, int totalPrice, PaymentMethod paymentMethod) {
        this.paymentId = paymentId;
        this.productPrice = productPrice;
        this.deliveryPrice = deliveryPrice;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", productPrice=" + productPrice +
                ", deliveryPrice=" + deliveryPrice +
                ", totalPrice=" + totalPrice +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
