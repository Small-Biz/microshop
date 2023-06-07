package com.smallbiz.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smallbiz.productservice.message.ProductRequest;
import com.smallbiz.productservice.model.ProductModel;
import com.smallbiz.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

	private final ProductService productService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createdProduct(@RequestBody ProductRequest request) {
		System.out.println("createdProduct");
		productService.createProduct(request);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductModel> getAllProducts() {
		
		System.out.println("getAllProducts");
		return productService.getAllProducts();
	}
}
