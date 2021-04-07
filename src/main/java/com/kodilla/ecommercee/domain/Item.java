package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ITEM_ID")
    private Long itemId;

    @ManyToMany (
            targetEntity = Product.class,
            mappedBy = "items",
            fetch = FetchType.LAZY
    )
    private List<Product> product;

    /*
    @ManyToOne (
            targetEntity = Cart.class,
            mappedBy = "item",
            fetch = FetchType.LAZY
    )
    private Cart cart;*/
}
