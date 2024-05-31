package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ItemCategory;

@Service
public interface ItemCategoryService {
    List<ItemCategory> getAllCategories();
    ItemCategory saveCategory(ItemCategory category);
    ItemCategory getCategoryById(Long id);
}