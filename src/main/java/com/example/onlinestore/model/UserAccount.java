package com.example.onlinestore.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String login;
    private String password;
    private Role role;
    @OneToOne
    private User user;

}
