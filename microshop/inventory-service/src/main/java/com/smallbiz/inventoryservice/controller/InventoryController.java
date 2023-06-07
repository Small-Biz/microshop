package com.smallbiz.inventoryservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smallbiz.inventoryservice.message.CheckInventoryResponse;
import com.smallbiz.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
	
	private final InventoryService inventoryService;
	
//	@GetMapping("/{sku-code}")
//	@ResponseStatus(HttpStatus.OK)
//	public boolean isInStock(@PathVariable("sku-code") String skuCode) {
//		return inventoryService.isInStock(skuCode);
//	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public CheckInventoryResponse checkInventory(@RequestParam List<String> skuCode) {
		
		System.out.println("checkInventory");
		
		return CheckInventoryResponse.builder()
				.inventoryList( inventoryService.isInStock(skuCode))
				.build();
		
	}
}
