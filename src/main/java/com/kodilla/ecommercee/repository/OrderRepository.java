package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Override
    public List<Order> findAll();

    @Override
    public Optional<Order> findById(Long OrderId);

    @Override
    public Order save(Order order);

    @Override
    public void deleteById(Long OrderId);

}
