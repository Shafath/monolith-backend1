package com.example.monolithbackend1.service;

import com.example.monolithbackend1.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> getOrders();
    Order getOrderById(Long orderId);

    Order updateOrder(Order order, Long orderId);

    void deleteOrder(Long orderId);
}
