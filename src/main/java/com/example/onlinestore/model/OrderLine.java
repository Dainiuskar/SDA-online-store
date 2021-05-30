package com.example.onlinestore.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Product product;

    Integer numberOfProducts;
    Double productPrice;
}
