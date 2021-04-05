package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {


    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder() {
        return new OrderDto(1L, true, false,
                LocalDate.of(2021, 2, 21));
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(Long orderId) {

    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(OrderDto orderDto) {
        return new OrderDto(1L, false, true,
                LocalDate.of(2021,03,25));
    }

    @PostMapping(value = "createOrder")
    public void createOrder(OrderDto orderDto) {

    }
}

