package com.example.onlinestore.service;

import com.example.onlinestore.model.entity.OrderLine;
import com.example.onlinestore.repo.OrderLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderLineService {

    OrderLineRepo orderLineRepo;

    @Autowired
    public OrderLineService(OrderLineRepo orderLineRepo) {
        this.orderLineRepo = orderLineRepo;
    }

    public OrderLine saveOrderLine(OrderLine orderLine) {
        return orderLineRepo.save(orderLine);
    }

    public List<OrderLine> getAllOrderLines() {
        return orderLineRepo.findAll();
    }

    public OrderLine getOrderLineById(Long id) {
        return orderLineRepo.getById(id);
    }

    public void updatedOrderLine(Map<String, String> idAndAmount) {
        OrderLine orderLine = orderLineRepo.getById(Long.parseLong(idAndAmount.get("id")));
        orderLine.setNumberOfProducts(Long.parseLong(idAndAmount.get("amount")));
        orderLineRepo.save(orderLine);
    }
}
