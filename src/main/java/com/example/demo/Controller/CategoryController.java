package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ItemCategoryService;
import com.example.demo.entity.ItemCategory;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    
    @Autowired
    private ItemCategoryService categoryService;
    
    @GetMapping("/categories")
    public List<ItemCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public ItemCategory getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public ItemCategory saveCategory(@RequestBody ItemCategory category) {
        return categoryService.saveCategory(category);
    }
}