package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ItemRepository;
import com.example.demo.Service.ItemService;
import com.example.demo.entity.ItemStock;

@Service
public class ItemServiceImpl implements ItemService{
    
    @Autowired
    private ItemRepository productRepository;

    @Override
    public List<ItemStock> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ItemStock getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ItemStock createProduct(ItemStock product) {
        return productRepository.save(product);
    }

    @Override
    public ItemStock updateProduct(Long id, ItemStock product) {
        ItemStock existProduct = productRepository.findById(id).orElse(null);

        if(existProduct == null) {
            return null;
        }

        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());
        existProduct.setCategory(product.getCategory());

        return productRepository.save(existProduct);

    }
}