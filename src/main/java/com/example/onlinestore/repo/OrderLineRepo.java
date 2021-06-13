package com.example.onlinestore.repo;

import com.example.onlinestore.model.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepo extends JpaRepository<OrderLine, Long> {
    boolean existsOrderLineByProductId(Long id);
}
