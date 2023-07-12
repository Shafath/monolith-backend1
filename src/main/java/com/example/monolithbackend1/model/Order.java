package com.example.monolithbackend1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "orderDate")
    private Date orderDate;

    @Column(name = "customerId")
    private long customerId;

    @Column(name = "productId")
    private long productId;
}
