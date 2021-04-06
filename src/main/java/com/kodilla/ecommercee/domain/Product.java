package com.kodilla.ecommercee.domain;

import java.util.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private String productDescription;
    private BigDecimal price;

    @ManyToOne
    private Group productGroup;

    @ManyToMany
    private List<Item> items;

    public Product(Long productId,
                   String productName,
                   String productDescription,
                   BigDecimal price,
                   Group productGroup) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.productGroup = productGroup;
    }

    public Product() {
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

    public Group getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(Group productGroup) {
        this.productGroup = productGroup;
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
