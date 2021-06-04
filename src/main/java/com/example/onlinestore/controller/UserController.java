package com.example.onlinestore.controller;

import com.example.onlinestore.model.entity.User;
import com.example.onlinestore.model.dto.UserAccountDTO;
import com.example.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/registration")
    public void userRegistration(@Valid @RequestBody UserAccountDTO userAccountDTO){
        userService.registerNewUserAccount(userAccountDTO);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
