package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class CartTestSuite {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void testFindAllCarts(){
        //Given
        Cart cart = new Cart();
        Cart cart2 = new Cart();

        //When
        cartRepository.save(cart);
        cartRepository.save(cart2);

        //Then
        assertEquals(2, cartRepository.findAll().size());

        //Clean Up
        cartRepository.deleteById(cart.getCartId());
        cartRepository.deleteById(cart2.getCartId());
    }

    @Test
    public void testSaveCart(){
        //Given
        Cart cart = new Cart();

        //When
        cartRepository.save(cart);
        long id = cart.getCartId();

        //Then
        assertNotEquals(0L, id);

        //Clean Up
        cartRepository.deleteById(cart.getCartId());
    }

    @Test
    public void testDeleteByIdCart(){
        //Given
        Cart cart = new Cart();

        //When
        cartRepository.save(cart);
        cartRepository.deleteById(cart.getCartId());

        //Then
        assertTrue(cartRepository.findAll().isEmpty());
    }

    @Test
    public void testRelationBetweenCartAndItem(){
        //Given
        Group group = new Group("Group 1");

        Product product1 = new Product("Product1 Name", "Product1 Description", new BigDecimal(110), group);

        Cart cart1 = new Cart();

        List<Product> products1 = new ArrayList<>();
        products1.add(product1);

        Item item1 = new Item(products1, cart1);

        List<Item> items1 = new ArrayList<>();
        items1.add(item1);

        item1.setProduct(products1);
        product1.setItems(items1);

        //When
        cartRepository.save(cart1);
        itemRepository.save(item1);

        long item1Id = item1.getItemId();
        long cart1Id = cart1.getCartId();

        //Then
        assertNotEquals(0L, cart1Id);
        assertNotEquals(0L, item1Id);

        //Clean
        cartRepository.deleteById(cart1Id);
        itemRepository.deleteById(item1Id);
    }

    @Test
    public void testRelationBetweenCartAndUser(){
        //Given
        User user = new User("Name1");
        Cart cart = new Cart();

        cart.setUser(user);

        userRepository.save(user);
        cartRepository.save(cart);

        //When
        long cartId = cart.getCartId();
        long userId = cart.getUser().getUserId();

        //Then
        assertNotEquals(0L, cartId);
        assertNotEquals(0L, userId);

        // Clean Up
        userRepository.deleteById(userId);
        cartRepository.deleteById(cartId);
    }

    @Test
    public void testRelationBetweenCartAndOrder(){
        //Given
        Order order = new Order(true, true, LocalDate.of(2021, 5, 23));
        Cart cart = new Cart();
        order.setCart(cart);
        cart.setOrder(order);

        //When
        orderRepository.save(order);
        cartRepository.save(cart);

        long cartId = order.getCart().getCartId();
        long orderId = cart.getOrder().getOrderId();
        boolean orderPaid = cart.getOrder().isPaid();

        //Then
        assertNotEquals(0L, cartId);
        assertNotEquals(0L, orderId);
        assertEquals(true, orderPaid);

        // Clean Up
//        orderRepository.deleteById(orderId);
//        cartRepository.deleteById(cartId);
    }
}
