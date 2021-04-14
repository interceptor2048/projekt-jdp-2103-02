package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductDbService productDbService;


    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productDbService.getAllProducts());
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotFoundException {
        return productMapper.mapToProductDto(productDbService.getProductById(productId));
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        productDbService.deleteProductById(productId);
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product updateProduct = productDbService.save(product);
        return productMapper.mapToProductDto(updateProduct);
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        productDbService.save(product);
    }

}
