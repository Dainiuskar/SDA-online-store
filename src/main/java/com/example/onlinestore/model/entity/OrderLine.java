package com.example.onlinestore.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Product product;

    Integer numberOfProducts;
    Double productPrice;
}
