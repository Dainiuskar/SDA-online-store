package com.example.onlinestore.service;

import com.example.onlinestore.model.entity.UserAccount;
import com.example.onlinestore.model.entity.UserDetailsAdapter;
import com.example.onlinestore.repo.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAccountDetailsService implements UserDetailsService {
    UserAccountRepo userAccountRepo;

    @Autowired
    public UserAccountDetailsService(UserAccountRepo userAccountRepo) {
        this.userAccountRepo = userAccountRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        UserAccount userAccount = userAccountRepo.findByLogin(login);
        if(userAccount == null)
            throw new UsernameNotFoundException(login + "not found");
        return new UserDetailsAdapter(userAccount);
    }
}
