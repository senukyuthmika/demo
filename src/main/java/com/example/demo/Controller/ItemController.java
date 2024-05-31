package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ItemCategoryService;
import com.example.demo.Service.ItemService;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ItemCategory;
import com.example.demo.entity.ItemStock;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
    
    @Autowired
    private ItemService productService;

    @Autowired
    private ItemCategoryService categoryService;

    @GetMapping("/products")
    public List<ItemStock> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ItemStock> getProductById(@PathVariable Long id) {
        ItemStock product = productService.getProductById(id);

        if(product != null) {
            return ResponseEntity.status(200).body(product);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<ItemStock> createProduct(@RequestBody ProductDto productDto) {
        ItemStock product = new ItemStock();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        
        //find category using categoryId in the ProductDTO
        ItemCategory category = categoryService.getCategoryById(productDto.getCategoryId());
        product.setCategory(category);
        
        ItemStock createdProduct = productService.createProduct(product);

        return ResponseEntity.status(201).body(createdProduct);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ItemStock> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {

        ItemStock product = new ItemStock();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        //find category using categoryId in the ProductDTO
        ItemCategory category = categoryService.getCategoryById(productDto.getCategoryId());
        product.setCategory(category);

        ItemStock updatedProduct = productService.updateProduct(id, product);

        if(updatedProduct != null) {
            return ResponseEntity.status(200).body(updatedProduct);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}