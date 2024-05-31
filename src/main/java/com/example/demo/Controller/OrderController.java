package com.example.demo.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.OrderService;
import com.example.demo.dto.AddProductDto;
import com.example.demo.entity.Order;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order createOrder() {
        Order order = new Order();
        order.setOrderDateTime(LocalDateTime.now());
        order.setTotalPrice(0.0);
        order.setOrderedProducts(null);

        return orderService.createOrder(order);
    }

    @PostMapping("/orders/{orderId}/addProducts")
    public Order addProductToOrder(@PathVariable Long orderId, @RequestBody AddProductDto addProductDto) {
        return orderService.addProductToOrder(orderId, addProductDto.getProductId(), addProductDto.getQuantity());
    }

    @DeleteMapping("/orders/{orderId}/product/{productId}")
    public Order removeProductFromOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        return orderService.removeProductFromOrder(orderId, productId);
    }
    
}