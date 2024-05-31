package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order addProductToOrder(Long orderId, Long productId, Integer quantity);
    Order removeProductFromOrder(Long orderId, Long productId);
}