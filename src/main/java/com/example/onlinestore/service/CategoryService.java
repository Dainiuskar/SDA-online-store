package com.example.onlinestore.service;

import com.example.onlinestore.model.entity.Category;
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

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }

    public void saveCategory(Long id, Category category) {
        Category toUpdate = categoryRepo.getById(id);
        toUpdate.setName(category.getName());
        toUpdate.setParentCategory(category.getParentCategory());
        categoryRepo.save(toUpdate);
    }
}
