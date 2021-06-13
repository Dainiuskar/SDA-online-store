package com.example.onlinestore.service;

import com.example.onlinestore.model.entity.OrderLine;
import com.example.onlinestore.model.entity.Product;
import com.example.onlinestore.repo.OrderLineRepo;
import com.example.onlinestore.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderLineService {

    OrderLineRepo orderLineRepo;
    ProductRepo productRepo;

    @Autowired
    public OrderLineService(OrderLineRepo orderLineRepo,
                            ProductRepo productRepo) {
        this.orderLineRepo = orderLineRepo;
        this.productRepo = productRepo;
    }

    public List<OrderLine> getAllOrderLines() {
        return orderLineRepo.findAll();
    }

    public void updatedOrderLine(Map<String, String> idAndAmount) {
        OrderLine orderLine = orderLineRepo.getById(Long.parseLong(idAndAmount.get("id")));
        orderLine.setNumberOfProducts(Long.parseLong(idAndAmount.get("amount")));
        orderLineRepo.save(orderLine);
    }

    public void deleteOrderLine(Long id) {
        orderLineRepo.deleteById(id);
    }

    public void saveOrderLine(Product product) {
        if (orderLineRepo.existsOrderLineByProductId(product.getId())) {
            OrderLine orderLine = orderLineRepo.getById(product.getId());
            orderLine.setNumberOfProducts(orderLine.getNumberOfProducts() + 1L);
            orderLineRepo.save(orderLine);
            return;
        }
        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(product);
        orderLine.setProductPrice(product.getPrice());
        orderLine.setNumberOfProducts(1L);
        orderLineRepo.save(orderLine);
    }
}
