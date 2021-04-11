package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private Long orderId;
    private boolean isPaid;
    private boolean isSend;
    private LocalDate orderDate;



}
