package com.kodilla.ecommercee.domain;

import java.math.BigDecimal;

public class ProductDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    //private ProductGroup productGroup;


    public ProductDto(Long productId, String productName, String productDescription, BigDecimal price) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
    }

    public ProductDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
