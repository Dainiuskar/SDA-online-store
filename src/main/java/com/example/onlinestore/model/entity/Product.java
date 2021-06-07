package com.example.onlinestore.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String description;

    @ManyToOne
    Category category;

    Double price;

    @Enumerated(EnumType.STRING)
    ProductType productType;
}
