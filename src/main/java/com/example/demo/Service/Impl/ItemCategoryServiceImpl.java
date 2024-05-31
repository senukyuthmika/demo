package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ItemCategoryRepository;
import com.example.demo.Service.ItemCategoryService;
import com.example.demo.entity.ItemCategory;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    
    @Autowired
    private ItemCategoryRepository categoryRepository;

    @Override
    public List<ItemCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ItemCategory saveCategory(ItemCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public ItemCategory getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
}