package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {

    public Order(boolean isPaid, boolean isSend, LocalDate orderDate) {
        this.isPaid = isPaid;
        this.isSend = isSend;
        this.orderDate = orderDate;
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", unique = true)
    private Long orderId;

    @Column(name = "PAID_VERIFICATION")
    private boolean isPaid;

    @Column(name = "SEND_VERIFICATION")
    private boolean isSend;

    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;


}
