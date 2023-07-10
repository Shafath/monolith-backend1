package com.example.monolithbackend1.serviceImpl;

import com.example.monolithbackend1.exception.ResourceNotFoundException;
import com.example.monolithbackend1.model.Product;
import com.example.monolithbackend1.repository.ProductRepository;
import com.example.monolithbackend1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return this.productRepository.findById(productId).orElseThrow(() ->
            new ResourceNotFoundException("Product", "Id", productId)
        );
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
        Product existingProduct = this.productRepository.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Product", "Id", productId)
        );
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setProductPrice(product.getProductPrice());
        return this.productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        this.productRepository.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Product", "Id", productId)
        );
        this.productRepository.deleteById(productId);
    }
}
