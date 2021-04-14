package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private Group productGroup;
    private List<Item> item;


    public ProductDto(Long productId, String productName, String productDescription, BigDecimal price) {
    }
}
