package com.kodilla.ecommercee.dto;

public class CartDto {

    private Long cartId;
//    private User user;
//    private Order order;

    public CartDto(Long cartId) {
        this.cartId = cartId;
    }

    public CartDto() {

    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
