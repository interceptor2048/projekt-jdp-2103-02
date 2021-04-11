package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long userId;
    private String userName;
    private boolean status = true;
    private int userKey = userKeyGenerator();

    private int userKeyGenerator() {
        Random randomGenerator = new Random();

        return (randomGenerator.nextInt(90000) + 10000);
    }
}
