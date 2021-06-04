package com.example.onlinestore.service;

import com.example.onlinestore.model.entity.Product;
import com.example.onlinestore.repo.CategoryRepo;
import com.example.onlinestore.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepo.findById(productId);
    }
}
