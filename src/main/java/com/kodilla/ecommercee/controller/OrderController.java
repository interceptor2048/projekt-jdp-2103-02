package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderMapper orderMapper;
    private final OrderDbService orderDbService;

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(orderDbService.getAllOrders());
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(orderDbService.getOrderById(orderId)
                                        .orElseThrow(OrderNotFoundException::new));
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        orderDbService.deleteOrderById(orderId);
    }

    @PutMapping(value = "updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        Order saveOrder = orderDbService.save(order);
        return orderMapper.mapToOrderDto(saveOrder);
    }

    @PostMapping(value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        orderDbService.save(order);
    }
}

