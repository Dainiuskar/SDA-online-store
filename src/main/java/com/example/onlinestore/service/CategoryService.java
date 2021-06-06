package com.example.onlinestore.service;

import com.example.onlinestore.model.Category;
import com.example.onlinestore.repo.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    public List<Category> getAllCategories(){
        return new ArrayList<>(categoryRepo.findAll());
    }
}
