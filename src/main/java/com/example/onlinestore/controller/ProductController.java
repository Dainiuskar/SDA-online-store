package com.example.onlinestore.controller;

import com.example.onlinestore.model.entity.Product;
import com.example.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/{productId}")
    public Product getProductById (@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @PostMapping(value = "/add")
    public void addProduct (@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PutMapping(value = "/edit")
    public void editProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }
}
