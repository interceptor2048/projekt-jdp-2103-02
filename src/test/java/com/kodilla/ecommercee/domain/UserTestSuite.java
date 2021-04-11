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
public class UserTestSuite {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testFindAllUsers() {
        //Given
        User user = new User("Name");
        User user2 = new User("Name");
        //When
        userRepository.save(user);
        userRepository.save(user2);

        //Then
        assertEquals(2, userRepository.findAll().size());

        //Clean Up
        userRepository.deleteById(user.getUserId());
        userRepository.deleteById(user2.getUserId());
    }

    @Test
    public void testSaveUser() {
        //Given
        User user = new User("Name");

        //When
        userRepository.save(user);
        long id = user.getUserId();

        //Then
        assertNotEquals(0L, id);

        //Clean Up
        userRepository.deleteById(id);
    }

    @Test
    public void testRelationBetweenUserAndOrder() {
        // Given
        User user = new User("Name");
        Order order = new Order(true, true, LocalDate.of(2000, 11,11));
        Order order2 = new Order(true, true, LocalDate.of(2000, 11,11));

        order.setUser(user);
        user.getOrders().add(order);
        user.getOrders().add(order2);

        // When
        userRepository.save(user);
        orderRepository.save(order);
        orderRepository.save(order2);

        long userId = user.getUserId();
        long orderId = order.getOrderId();
        long orderId2 = order2.getOrderId();
        int ordersUser = user.getOrders().size();

        //Then
        assertNotEquals(0L, userId);
        assertNotEquals(0L, orderId);
        assertNotEquals(0L, orderId2);
        assertEquals(2, ordersUser);

        //Clean Up
        userRepository.delete(user);
    }

    @Test
    public void testRelationBetweenUserAndCart() {
        //Given
        User user = new User("Name");
        Cart cart = new Cart();
        Cart cart1 = new Cart();

        user.getCart().add(cart);
        user.getCart().add(cart1);
        cart.setUser(user);
        cart1.setUser(user);

        userRepository.save(user);
        cartRepository.save(cart);
        cartRepository.save(cart1);

        //When
        long userId = user.getUserId();
        int userCarts = user.getCart().size();

        //Then
        assertNotEquals(0L, userId);
        assertEquals(2, userCarts);

        // Clean Up
        userRepository.delete(user);
    }
}
