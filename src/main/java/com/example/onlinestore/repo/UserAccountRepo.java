package com.example.onlinestore.repo;

import com.example.onlinestore.model.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {
    boolean existsByLogin(String login);
}

