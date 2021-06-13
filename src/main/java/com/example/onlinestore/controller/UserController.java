package com.example.onlinestore.controller;

import com.example.onlinestore.model.entity.User;
import com.example.onlinestore.model.dto.UserAccountDTO;
import com.example.onlinestore.model.entity.UserAccount;
import com.example.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "user")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@Valid @RequestBody UserAccountDTO userAccountDTO) {
        userService.registerNewUserAccount(userAccountDTO);
    }

    @GetMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/accounts")
    public List<UserAccount> getAllUserAccounts(){
        return userService.getAllUserAccounts();
    }

    @GetMapping(value = "/{login}")
    public UserAccount getUserAccount(@PathVariable String login){
        return userService.getUserAccountByLogin(login);
    }
}
