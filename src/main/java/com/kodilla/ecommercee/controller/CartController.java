package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PostMapping(value = "createCart")
    public void createCart(@RequestBody CartDto cartDto) {

    }

    @GetMapping(value = "getCart")
    public CartDto getCart(@RequestParam Long cartId) {

        return new CartDto(1L);

    }

    @PutMapping(value = "addItemToCart")
    public void addItemToCart(Long cartId, Long itemId) {

    }

    @DeleteMapping(value = "deleteItemFromCart")
    public void deleteItemFromCart(Long cartId, Long itemId) {

    }

    @PostMapping(value = "createOrder")
    public void createOrder() {

    }
}

