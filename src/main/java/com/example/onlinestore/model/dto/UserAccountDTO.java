package com.example.onlinestore.model.dto;

import com.example.onlinestore.validation.UserAccountNotExist;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@UserAccountNotExist(message = "User account already exists, try another login")
public class UserAccountDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    private String login;

    @NotNull
    @NotEmpty
    @NotBlank
    private String password;

    @NotNull
    @NotEmpty
    @NotBlank
    private String firstname;

    @NotNull
    @NotEmpty
    @NotBlank
    private String lastname;

    private String country;
    private String city;
    private String street;
    private String zipCode;
}
