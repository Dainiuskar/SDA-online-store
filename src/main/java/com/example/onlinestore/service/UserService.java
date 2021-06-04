package com.example.onlinestore.service;

import com.example.onlinestore.model.entity.Address;
import com.example.onlinestore.model.entity.Role;
import com.example.onlinestore.model.entity.User;
import com.example.onlinestore.model.entity.UserAccount;
import com.example.onlinestore.model.dto.UserAccountDTO;
import com.example.onlinestore.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final AddressRepo addressRepo;
    private final UserAccountRepo userAccountRepo;
    private final UserRepo userRepo;

    @Autowired
    public UserService(AddressRepo addressRepo,
                       UserAccountRepo userAccountRepo,
                       UserRepo userRepo) {
        this.addressRepo = addressRepo;
        this.userAccountRepo = userAccountRepo;
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void registerNewUserAccount(UserAccountDTO userAccountDTO) {
        Address address = createAddress(userAccountDTO);
        User user = createUser(userAccountDTO, address);
        UserAccount userAccount = new UserAccount(userAccountDTO.getLogin(),
                userAccountDTO.getPassword(),
                Role.USER,
                user);
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
}
