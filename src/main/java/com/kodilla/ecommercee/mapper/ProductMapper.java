package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.service.GroupDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductMapper {
    @Autowired
    private GroupDbService groupDbService;

    public Product mapToProduct(final ProductDto productDto) throws GroupNotFoundException {
        Group group = groupDbService.getGroupById(productDto.getGroupId()).orElseThrow(GroupNotFoundException::new);
        return new Product(
                productDto.getProductId(),
                productDto.getProductName(),
                productDto.getProductDescription(),
                productDto.getPrice(),
                group
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getPrice(),
                product.getProductGroup().getGroupId()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> productDtoList) throws GroupNotFoundException {
        List<Product> list = new ArrayList<>();
        for (ProductDto element : productDtoList){
            list.add(mapToProduct(element));
        }
        return list;
    }
}
