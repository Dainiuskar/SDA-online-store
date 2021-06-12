package com.example.onlinestore.model.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "required")
    private String name;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Category parentCategory;
}
