package com.example.onlinestore.model.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    List<OrderLine> orderLines;

    public Cart() {
        this.orderLines = new ArrayList<>();
    }
}
