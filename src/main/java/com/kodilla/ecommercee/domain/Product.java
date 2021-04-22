package com.kodilla.ecommercee.domain;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID", unique = true)
    private Long productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "DESCRIPTION")
    private String productDescription;

    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "GROUP_ID")
    private Group productGroup;

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Item> items;

    public Product(String productName,
                   String productDescription,
                   BigDecimal price,
                   Group productGroup) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.productGroup = productGroup;
    }

    public Product(@NotNull Long productId,
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
}

