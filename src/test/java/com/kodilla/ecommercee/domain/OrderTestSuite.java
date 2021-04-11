package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderTestSuite {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testFindAllOrders() {
        //Given
        Order order = new Order(true, true, LocalDate.of(2021, 1, 23));
        Order order1 = new Order(true, true, LocalDate.of(2021, 2, 12));

        //When
        orderRepository.save(order);
        orderRepository.save(order1);

        //Then
        assertEquals(2, orderRepository.findAll().size());

        //Clean Up
        orderRepository.deleteById(order.getOrderId());
        orderRepository.deleteById(order1.getOrderId());
    }

    @Test
    public void testSaveOrder() {
        //Given
        Order order = new Order(true, true, LocalDate.of(2020, 9, 1));

        //When
        orderRepository.save(order);
        long id = order.getOrderId();

        //Then
        assertNotEquals(0L, id);

        //Clean Up
        orderRepository.deleteById(id);
    }

    @Test
    public void testRelationBetweenOrderAndUser() {
        //Given
        Order order = new Order(true, false, LocalDate.of(1999, 5, 30));
        Order order1 = new Order(false, true, LocalDate.of(2021, 7, 25));
        User user = new User ("TestName", 1, 12345, LocalDate.of(2021, 5, 10));

        order.setUser(user);
        order1.setUser(user);

        //When
        orderRepository.save(order);
        orderRepository.save(order1);
        userRepository.save(user);

        long userId = user.getUserId();
        long orderId = order.getOrderId();
        long order1Id = order1.getOrderId();
        long OrderForUser = order.getUser().getUserId();
        long Order1ForUser = order1.getUser().getUserId();

        //Then
        assertNotEquals(0L, userId);
        assertNotEquals(0L, orderId);
        assertNotEquals(0L, order1Id);
        assertEquals(OrderForUser, Order1ForUser);

        //Clean Up
        userRepository.deleteById(userId);
        orderRepository.deleteById(orderId);
        orderRepository.deleteById(order1Id);
    }

//    @Test
//    public void testRelationBetweenOrderAndCart() {
//        //Given
//        Order order = new Order(true, true, LocalDate.of(2021, 5, 23));
//        Cart cart = new Cart();
//
//
//    }
}
