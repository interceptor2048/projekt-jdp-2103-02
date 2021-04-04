package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        LOGGER.info("Product list has been displayed");
        return new ArrayList<>();
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(Long productId) {
        LOGGER.info("Product has been displayed");
        return new ProductDto(1L,
                "Test product",
                "Test product description",
                new BigDecimal(100.0),
                new Group(1L,
                        "Test group name"));
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(Long productId) {
        LOGGER.info("Product has been deleted");
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(ProductDto productDto) {
        LOGGER.info("Product has been updated");
        return new ProductDto(1L,
                "Test update product",
                "Test update description",
                new BigDecimal(150.0),
                new Group(1L,
                "Test group name"));
    }

    @PostMapping(value = "createProduct")
    public void createProduct(ProductDto productDto) {
        LOGGER.info("Product has been created");
    }
}
