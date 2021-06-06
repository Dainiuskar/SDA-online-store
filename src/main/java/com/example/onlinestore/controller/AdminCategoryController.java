package com.example.onlinestore.controller;

import com.example.onlinestore.model.entity.Category;
import com.example.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "admin/category")
public class AdminCategoryController {

    CategoryService categoryService;

    @Autowired
    public AdminCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping(value = "/add")
    public void addNewCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

    @PutMapping(value = "update/{id}")
    public void update(@RequestBody Category category, @PathVariable Long id) {
        categoryService.saveCategory(id, category);
    }
}
