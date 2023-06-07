package com.smallbiz.inventoryservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smallbiz.inventoryservice.entity.Inventory;
import com.smallbiz.inventoryservice.model.InventoryModel;
import com.smallbiz.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

	private final InventoryRepository inventoryRepository;
	
	@Transactional(readOnly = true)
	@SneakyThrows
	public List<InventoryModel> isInStock(List<String> skuCodeList) {

		log.info("Wait Started");
//		Thread.sleep(10000);
		log.info("Wait Ended");
		return inventoryRepository.findBySkuCodeIn(skuCodeList).stream()
				.map(this::mapToModel).collect(Collectors.toList());
	}
	
	private InventoryModel mapToModel(Inventory inventory) {
		return InventoryModel.builder()
				.skuCode(inventory.getSkuCode())
				.inStock(inventory.getQuantity()>0)
				.build();
	}
}
