package com.example.onlinestore.service;

import com.example.onlinestore.model.entity.*;
import com.example.onlinestore.repo.*;
import com.example.onlinestore.model.dto.UserAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private final AddressRepo addressRepo;
    private final UserAccountRepo userAccountRepo;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(AddressRepo addressRepo,
                       UserAccountRepo userAccountRepo,
                       UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.addressRepo = addressRepo;
        this.userAccountRepo = userAccountRepo;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void registerNewUserAccount(UserAccountDTO userAccountDTO) {
        Address address = createAddress(userAccountDTO);
        User user = createUser(userAccountDTO, address);
        UserAccount userAccount = new UserAccount(
                userAccountDTO.getLogin(),
                passwordEncoder.encode(userAccountDTO.getPassword()),
                Role.USER,
                user);
        userAccount.setLogin(userAccountDTO.getLogin());
        userAccountRepo.save(userAccount);
    }

    private User createUser(UserAccountDTO userAccountDTO, Address address) {
        User user = new User(userAccountDTO.getFirstname(),
                userAccountDTO.getLastname(),
                address);
        userRepo.save(user);
        return user;
    }

    private Address createAddress(UserAccountDTO userAccountDTO) {
        Address address = new Address(userAccountDTO.getCountry(),
                userAccountDTO.getCity(),
                userAccountDTO.getStreet(),
                userAccountDTO.getZipCode());
        addressRepo.save(address);
        return address;
    }

    public List<UserAccount> getAllUserAccounts() {
        return userAccountRepo.findAll();
    }
}
