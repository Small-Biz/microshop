package com.smallbiz.productservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.smallbiz.productservice.entity.Product;
import com.smallbiz.productservice.message.ProductRequest;
import com.smallbiz.productservice.model.ProductModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	
	public void createProduct( ProductRequest request) {
		
		Product product=Product.builder()
				.name(request.getName())
				.description(request.getDescription())
				.price(request.getPrice()).build();
		
		productRepository.save(product);
		
	}
	
	public List<ProductModel> getAllProducts() {		
		return productRepository.findAll().stream().map(this::mapToModel).collect(Collectors.toList());
	}
	
	private ProductModel mapToModel(Product entity) {
		return ProductModel.builder().id(entity.getId())
				.name(entity.getName())
				.description(entity.getDescription())
				.price(entity.getPrice())
				.build();
	}
	
}
