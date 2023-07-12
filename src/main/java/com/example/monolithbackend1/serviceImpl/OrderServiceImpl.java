package com.example.monolithbackend1.serviceImpl;

import com.example.monolithbackend1.exception.ResourceNotFoundException;
import com.example.monolithbackend1.model.Order;
import com.example.monolithbackend1.model.Order;
import com.example.monolithbackend1.repository.OrderRepository;
import com.example.monolithbackend1.repository.OrderRepository;
import com.example.monolithbackend1.service.OrderService;
import com.example.monolithbackend1.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        super();
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order product) {
        return this.orderRepository.save(product);
    }

    @Override
    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return this.orderRepository.findById(orderId).orElseThrow(() ->
            new ResourceNotFoundException("Order", "Id", orderId)
        );
    }

    @Override
    public Order updateOrder(Order product, Long orderId) {
        Order existingOrder = this.orderRepository.findById(orderId).orElseThrow(() ->
                new ResourceNotFoundException("Order", "Id", orderId)
        );
        existingOrder.setCustomerId(existingOrder.getCustomerId());
        existingOrder.setOrderId(product.getOrderId());
        existingOrder.setOrderDate(new Date());
        return this.orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        this.orderRepository.findById(orderId).orElseThrow(() ->
                new ResourceNotFoundException("Order", "Id", orderId)
        );
        this.orderRepository.deleteById(orderId);
    }
}
