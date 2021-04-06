package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class GroupTestSuite {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveGroupInRepository() {
        //Given
        Group testGropu = new Group("Test group");

        //When
        groupRepository.save(testGropu);
        Long testGroupId = testGropu.getGroupId();


        //Then
        assertTrue(0L != testGroupId);

        //Clean repository
        groupRepository.deleteById(testGroupId);
    }

    @Test
    public void testDeleteGroupInRepository() {
        //Given
        Group testGroup = new Group("Test group");

        //When
        groupRepository.save(testGroup);
        Long testGroupId = testGroup.getGroupId();
        groupRepository.deleteById(testGroupId);

        List<Group> optionalGroup = groupRepository.findAll();

        //Then
        assertTrue(optionalGroup.isEmpty());
    }

    @Test
    public void testConnectionBetweenGroupAndProduct () {
        //Given
        Group testGroup = new Group("Test group");
        Product testProduct1 = new Product();
        Product testProduct2 = new Product();

        testProduct1.setProductName("Test product 1");
        testProduct1.setProductDescription("Description of test product 1");
        testProduct1.setPrice(new BigDecimal(100.0));
        testProduct1.setProductGroup(testGroup);

        testProduct2.setProductName("Test product 1");
        testProduct2.setProductDescription("Description of test product 1");
        testProduct2.setPrice(new BigDecimal(100.0));
        testProduct2.setProductGroup(testGroup);

        testGroup.getProductList().add(testProduct1);
        testGroup.getProductList().add(testProduct2);

        //When
        productRepository.save(testProduct1);
        productRepository.save(testProduct2);
        groupRepository.save(testGroup);

        Long testProduct1Id = testProduct1.getProductId();
        Long testProduct2Id = testProduct2.getProductId();
        Long testGroupId = testGroup.getGroupId();

        List<Product> testProductList = testGroup.getProductList();

        //Then
        assertFalse(0L == testGroupId);
        assertFalse(0L == testProduct1Id);
        assertFalse(0 == testProduct2Id);
        assertEquals(2, testProductList.size());

        //Clean repository
        productRepository.deleteById(testProduct1Id);
        productRepository.deleteById(testProduct2Id);
        groupRepository.deleteById(testGroupId);
    }
}
