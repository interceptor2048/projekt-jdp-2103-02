package com.kodilla.ecommercee.domain;

import java.time.LocalDate;

public class Order {

    private Long orderId;
    private boolean isPaid;
    private boolean isSend;
    private LocalDate orderDate;
    //private User user;


    public Order(Long orderId, boolean isPaid, boolean isSend, LocalDate orderDate) {
        this.orderId = orderId;
        this.isPaid = isPaid;
        this.isSend = isSend;
        this.orderDate = orderDate;
    }

    public Order() {

    }

    public Long getOrderId() {
        return orderId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isSend() {
        return isSend;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
