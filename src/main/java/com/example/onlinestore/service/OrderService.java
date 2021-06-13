package com.example.onlinestore.service;

import com.example.onlinestore.model.entity.OrderP;
import com.example.onlinestore.repo.OrderLineRepo;
import com.example.onlinestore.repo.OrderRepo;
import com.example.onlinestore.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepo orderRepo;
    OrderLineRepo orderLineRepo;
    ProductRepo productRepo;
    UserService userService;

    @Autowired
    public OrderService(OrderRepo orderRepo,
                        OrderLineRepo orderLineRepo,
                        ProductRepo productRepo,
                        UserService userService) {
        this.orderRepo = orderRepo;
        this.orderLineRepo = orderLineRepo;
        this.productRepo = productRepo;
        this.userService = userService;
    }


    public List<OrderP> getAll() {
        return orderRepo.findAll();
    }
}
