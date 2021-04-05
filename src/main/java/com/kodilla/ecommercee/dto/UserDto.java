package com.kodilla.ecommercee.dto;

import java.time.LocalDate;

public class UserDto {

    private Long userId;
    private String userName;
    private int status;
    private int userKey;
    private LocalDate expirationDate;

    public UserDto(Long userId, String userName, int status, int userKey, LocalDate expirationDate) {
        this.userId = userId;
        this.userName = userName;
        this.status = status;
        this.userKey = userKey;
        this.expirationDate = expirationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getStatus() {
        return status;
    }

    public int getUserKey() {
        return userKey;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
