package com.example.onlinestore.repo;

import com.example.onlinestore.model.entity.OrderP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderP, Long> {
}
