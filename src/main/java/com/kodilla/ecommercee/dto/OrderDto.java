package com.kodilla.ecommercee.dto;

import java.time.LocalDate;

public class OrderDto {

    private Long orderId;
    private boolean isPaid;
    private boolean isSend;
    private LocalDate orderDate;
    //private User user;

    public OrderDto(Long orderId, boolean isPaid, boolean isSend, LocalDate orderDate) {
        this.orderId = orderId;
        this.isPaid = isPaid;
        this.isSend = isSend;
        this.orderDate = orderDate;
    }

    public OrderDto() {

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
