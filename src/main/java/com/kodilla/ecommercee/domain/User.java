package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    public User(@NotNull Long userId, @NotNull String userName, @NotNull boolean status) {
        this.userId = userId;
        this.userName = userName;
        this.status = status;
        this.userKey = generateUserKey();
        this.expirationDate = LocalDateTime.now().plusHours(1);
    }

    public User (@NotNull Long userId,  String userName,  boolean status,  int userKey) {
        this.userId = userId;
        this.userName = userName;
        this.status = status;
        this.userKey = userKey;
        this.expirationDate = LocalDateTime.now().plusHours(1);
    }

    public User ( String userName) {
        this.userName = userName;
        status = true;
        userKey = generateUserKey();
        this.expirationDate = LocalDateTime.now().plusHours(1);
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", unique = true)
    private Long userId;

    @NotNull
    @Column(name = "USER_NAME")
    private String userName;

    @NotNull
    @Column(name = "STATUS")
    private boolean status;

    @NotNull
    @Column(name = "USER_KEY")
    private int userKey;

    @Column(name = "EXPIRATION_DATE")
    private LocalDateTime expirationDate;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orders = new ArrayList<>();

    @OneToMany(
            targetEntity = Cart.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Cart> cart = new ArrayList<>();

    public int generateUserKey() {
        Random randomGenerator = new Random();
        this.expirationDate = LocalDateTime.now().plusHours(1);
        return (randomGenerator.nextInt(90000) + 10000);
    }
}
