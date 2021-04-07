package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    public User(@NotNull String userName, @NotNull int status, @NotNull int userKey, @NotNull LocalDate expirationDate) {
        this.userName = userName;
        this.status = status;
        this.userKey = userKey;
        this.expirationDate = expirationDate;
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
    private int status;

    @NotNull
    @Column(name = "USER_KEY")
    private int userKey;

    @NotNull
    @Column(name = "EXPIRATION_DATE")
    private LocalDate expirationDate;

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




}
