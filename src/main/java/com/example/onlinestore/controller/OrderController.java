package com.example.onlinestore.controller;

import com.example.onlinestore.model.entity.OrderLine;
import com.example.onlinestore.model.entity.OrderP;
import com.example.onlinestore.service.OrderLineService;
import com.example.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    OrderService orderService;
    OrderLineService orderLineService;

    @Autowired
    public OrderController(OrderService orderService,
                           OrderLineService orderLineService) {
        this.orderService = orderService;
        this.orderLineService = orderLineService;
    }

    @GetMapping
    public List<OrderP> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping(value = "/orderLines")
    public List<OrderLine> getAllOrderLines() {
        return orderLineService.getAllOrderLines();
    }

    @PutMapping(value = "/updateOrderLine")
    public void updateOrderLine(@RequestBody Map<String, String> idAndAmount) {
        orderLineService.updatedOrderLine(idAndAmount);
    }
}
