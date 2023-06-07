package com.smallbiz.inventoryservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smallbiz.inventoryservice.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

//	Optional<Inventory>  findBySkuCode(String skuCode);
	
	List<Inventory> findBySkuCodeIn(List<String> skuCodeList);
}
