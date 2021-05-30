package com.example.onlinestore.service;

import com.example.onlinestore.model.User;
import com.example.onlinestore.repo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final AddressRepo addressRepo;
    private final CategoryRepo categoryRepo;
    private final OrderLineRepo orderLineRepo;
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;
    private final UserAccountRepo userAccountRepo;
    private final UserRepo userRepo;

    public UserService(AddressRepo addressRepo,
                       CategoryRepo categoryRepo,
                       OrderLineRepo orderLineRepo,
                       OrderRepo orderRepo,
                       ProductRepo productRepo,
                       UserAccountRepo userAccountRepo,
                       UserRepo userRepo) {
        this.addressRepo = addressRepo;
        this.categoryRepo = categoryRepo;
        this.orderLineRepo = orderLineRepo;
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.userAccountRepo = userAccountRepo;
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userRepo.findAll());
    }
}
