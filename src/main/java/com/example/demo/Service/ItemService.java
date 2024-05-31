package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ItemStock;

@Service
public interface ItemService {
    List<ItemStock> getAllProducts();
    ItemStock getProductById(Long id);
    ItemStock createProduct(ItemStock product);
    ItemStock updateProduct(Long id, ItemStock product);
}
