package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getProductId(),
                productDto.getProductName(),
                productDto.getProductDescription(),
                productDto.getPrice(),
                productDto.getProductGroup(),
                productDto.getItem()
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getPrice(),
                product.getProductGroup(),
                product.getItems()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }
}
