package com.kodilla.ecommercee.mapper;


import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.service.CartDbService;
import com.kodilla.ecommercee.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderMapper {

    private final CartDbService cartDbService;
    private final UserDbService userDbService;

    public Order mapToOrder(final OrderDto orderDto) {
        User user = userDbService.getUserById(orderDto.getUserId()).orElse(null);
        Cart cart = cartDbService.getCartById(orderDto.getCartId());
        return new Order(
                orderDto.getOrderId(),
                orderDto.isPaid(),
                orderDto.isPaid(),
                orderDto.getOrderDate(),
                user,
                cart
        );
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.isPaid(),
                order.isSend(),
                order.getOrderDate(),
                order.getUser().getUserId(),
                order.getCart().getCartId()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
