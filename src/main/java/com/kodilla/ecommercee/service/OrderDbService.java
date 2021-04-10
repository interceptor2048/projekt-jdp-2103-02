package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
public class OrderDbService {

    private final OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Optional<Order> getOrderById(final Long orderId) {
        return repository.findById(orderId);
    }

    public Order save(final Order order) {
        return repository.save(order);
    }

    public void deleteOrderById(final Long orderId) {
        repository.deleteById(orderId);
    }

}
