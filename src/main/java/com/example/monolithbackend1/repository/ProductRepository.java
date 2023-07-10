package com.example.monolithbackend1.repository;

import com.example.monolithbackend1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
