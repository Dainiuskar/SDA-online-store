package com.example.onlinestore.service;

import com.example.onlinestore.model.entity.Product;
import com.example.onlinestore.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PreAuthorize("hasRole('ADMIN')")
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @PreAuthorize("permitAll()")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @PreAuthorize("permitAll()")
    public Product getProductById(Long productId) {
        return productRepo.findOneById(productId);
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public void updateProduct(Product product) {
        Product editedProduct = getProductById(product.getId());
        editedProduct.setTitle(product.getTitle());
        editedProduct.setDescription(product.getDescription());
        editedProduct.setPrice(product.getPrice());
        editedProduct.setProductType(product.getProductType());
        productRepo.save(editedProduct);
    }
}
