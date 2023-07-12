package com.example.monolithbackend1.repository;

import com.example.monolithbackend1.model.Order;
import com.example.monolithbackend1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
