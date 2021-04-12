package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ItemRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class ProductTestSuite {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindAllProducts() {
        //Given
        Group group = new Group("Group 1");

        Product product1 = new Product("Product1 Name", "Product1 Description", new BigDecimal(110), group);
        Product product2 = new Product("Product2 Name", "Product2 Description", new BigDecimal(110), group);

        //When
        productRepository.save(product1);
        productRepository.save(product2);

        //Then
        assertEquals(2, productRepository.findAll().size());

        //CleanUp
        productRepository.deleteById(product1.getProductId());
        productRepository.deleteById(product2.getProductId());
    }

    @Test
    public void testSaveProductInRepository() {
        //Given
        Group group = new Group("Group 1");

        Product product1 = new Product("Product1 Name", "Product1 Description", new BigDecimal(110), group);

        //When
        productRepository.save(product1);
        Long id = product1.getProductId();

        //Then
        assertTrue(0L != id);

        //CleanUp
        productRepository.deleteById(id);
    }

    @Test
    public void testDeleteProductsIneRepository() {
        //Given
        Group group = new Group("Group 1");

        Product product1 = new Product("Product1 Name", "Product1 Description", new BigDecimal(110), group);

        //When
        productRepository.save(product1);
        productRepository.deleteById(product1.getProductId());

        //Then
        assertTrue(productRepository.findAll().isEmpty());

    }

    @Test
    public void testRelationBetweenProductAndGroup() {

        //Given
        Group group = new Group("Group 1");

        Product product1 = new Product("Product1 Name", "Product1 Description", new BigDecimal(110), group);
        Product product2 = new Product("Product2 Name", "Product2 Description", new BigDecimal(110), group);

        product1.setProductGroup(group);
        group.getProductList().add(product1);
        group.getProductList().add(product2);

        //When
        productRepository.save(product1);
        productRepository.save(product2);
        groupRepository.save(group);

        long product1Id = product1.getProductId();
        long product2Id = product2.getProductId();
        long groupId = group.getGroupId();
        int productsInGroup = group.getProductList().size();

        //Then
        assertNotEquals(0L, product1Id);
        assertNotEquals(0L, product2Id);
        assertNotEquals(0L, groupId);
        assertEquals(2, productsInGroup);

        //CleanUp
        groupRepository.delete(group);
    }

    @Test
    public void testRelationBetweenProductAndItem() {

        //Given
        Group group = new Group("Group 1");

        Product product1 = new Product("Product1 Name", "Product1 Description", new BigDecimal(110), group);
        Product product2 = new Product("Product2 Name", "Product2 Description", new BigDecimal(110), group);

        Cart cart1 = new Cart(1L, 2L, 3L);
        Cart cart2 = new Cart(6L, 5L, 4L);

        List<Product> products1 = new ArrayList<>();
        products1.add(product1);

        List<Product> products2 = new ArrayList<>();
        products2.add(product2);

        Item item1 = new Item(products1, cart1);
        Item item2 = new Item(products2, cart2);

        List<Item> items1 = new ArrayList<>();
        items1.add(item1);

        List<Item> items2 = new ArrayList<>();
        items2.add(item2);

        item1.setProduct(products1);
        item2.setProduct(products2);

        product1.setItems(items1);
        product2.setItems(items2);

        //When
        itemRepository.save(item1);
        itemRepository.save(item2);
        productRepository.save(product1);
        productRepository.save(product2);

        long item1Id = item1.getItemId();
        long item2Id = item2.getItemId();

        long product1Id = product1.getProductId();
        long product2Id = product2.getProductId();

        int size = item1.getProduct().size();

        //Then
        assertNotEquals(0L, product1Id);
        assertNotEquals(0L, product2Id);
        assertNotEquals(0L, item1Id);
        assertNotEquals(0L, item2Id);
        assertEquals(1, size);

        //Clean
        productRepository.deleteById(product1Id);
        productRepository.deleteById(product2Id);
     }


}
