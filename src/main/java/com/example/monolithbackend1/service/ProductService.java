package com.example.monolithbackend1.service;

import com.example.monolithbackend1.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getProducts();
    Product getProductById(Long productId);

    Product updateProduct(Product product, Long productId);

    void deleteProduct(Long productId);
}
