package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private Long groupId;

    public ProductDto(String productName,
                      String productDescription,
                      BigDecimal price,
                      Long groupId) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.groupId = groupId;
    }
}
