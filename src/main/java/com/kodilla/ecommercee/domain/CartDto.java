package com.kodilla.ecommercee.domain;

public class CartDto {

    private Long cartId;
//    private User user;
//    private Order order;

    public CartDto(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
