package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.service.ItemDbService;
import com.kodilla.ecommercee.service.OrderDbService;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartMapper {

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    ItemDbService itemDbService;

    @Autowired
    OrderDbService orderDbService;

    @Autowired
    UserDbService userDbService;


    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(
                cart.getCartId(),
                getIdFromUser(cart),
                getIdFromOrder(cart)
        );
    }

    public Cart mapToCart(final CartDto cartDto) {
        User user = userDbService.getUserById(cartDto.getUserId()).orElse(null);
        Order order = orderDbService.getOrderById(cartDto.getOrderId()).orElse(null);
        return new Cart(
                cartDto.getCartId(),
                user,
                order,
                null
        );
    }

    private Long getIdFromUser(Cart cart) {
        try {
            return cart.getUser().getUserId();
        } catch (Exception e) {
            return null;
        }
    }

    private Long getIdFromOrder(Cart cart) {
        try {
            return cart.getOrder().getOrderId();
        } catch (Exception e) {
            return null;
        }
    }


}
