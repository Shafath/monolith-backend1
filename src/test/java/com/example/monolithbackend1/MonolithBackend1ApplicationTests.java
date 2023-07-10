package com.example.monolithbackend1;

import com.example.monolithbackend1.model.Product;
import com.example.monolithbackend1.repository.ProductRepository;
import com.example.monolithbackend1.service.ProductService;
import com.example.monolithbackend1.serviceImpl.ProductServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MonolithBackend1ApplicationTests {
	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductServiceImpl productService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void getAllProducts() {
		//bca
		List<Product> productList = new ArrayList<>();
		Product product1 = new Product();
		product1.setProductId(1);
		product1.setProductName("Test");
		product1.setProductDescription("Test Description");
		product1.setProductPrice(100.0);
		productList.add(product1);

		Mockito.when(productRepository.findAll()).thenReturn(productList);

		List<Product> products = this.productService.getProducts();
		Assertions.assertEquals(1, products.size());

	}
}
