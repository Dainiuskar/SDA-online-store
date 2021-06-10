package com.example.onlinestore.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAccount extends Cart{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    private User user;

    public UserAccount(String login, String password, Role role, User user) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.user = user;
    }
}
