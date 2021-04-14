package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Item;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartDbService;
import com.kodilla.ecommercee.service.ItemDbService;
import com.kodilla.ecommercee.service.OrderDbService;
import com.kodilla.ecommercee.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/cart")
public class CartController {

    private final CartMapper cartMapper;

    private final CartDbService cartDbService;

    private final ItemDbService itemDbService;

    private final UserDbService userDbService;

    private final OrderDbService orderDbService;

    @PostMapping(value = "createCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
        cartDbService.save(cartMapper.mapToCart(cartDto));
    }

    @GetMapping(value = "getCart")
    public CartDto getCart(@RequestParam Long cartId) {
        return cartMapper.mapToCartDto(cartDbService.getCartById(cartId));
    }

    @PutMapping(value = "addItemToCart")
    public CartDto addItemToCart1(@RequestParam Long cartId, @RequestParam Long itemId) {
        Item item = itemDbService.getItem(itemId);
        Cart cart = cartDbService.getCartById(cartId);
        cart.getItems().add(item);
        cartDbService.save(cart);
        return cartMapper.mapToCartDto(cart);
    }

    @DeleteMapping(value = "deleteItemFromCart")
    public void deleteItemFromCart(@RequestParam Long cartId, @RequestParam Long itemId) {
        Item item = itemDbService.getItem(itemId);
        Cart cart = cartDbService.getCartById(cartId);
        cart.getItems().remove(item);
        cartDbService.save(cart);
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestParam Long userId, @RequestParam Long cartId) throws UserNotFoundException {
        Cart cart = cartDbService.getCartById(cartId);
        User user = userDbService.getUserById(userId).orElseThrow(UserNotFoundException::new);
        Order order = new Order();
        order.setCart(cart);
        order.setUser(user);
        order.setOrderDate(LocalDate.now());
        orderDbService.save(order);
    }
}

