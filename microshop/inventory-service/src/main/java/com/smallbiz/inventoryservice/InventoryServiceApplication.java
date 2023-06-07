package com.smallbiz.inventoryservice;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.annotation.Bean;
//import com.smallbiz.inventoryservice.entity.Inventory;
//import com.smallbiz.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
//		return args ->{
//			Inventory inventory1=new Inventory();
//			inventory1.setSkuCode("iphone_13");
//			inventory1.setQuantity(13);
//			
//			Inventory inventory2=new Inventory();
//			inventory2.setSkuCode("iphone_12");
//			inventory2.setQuantity(2);
//			
//			Inventory inventory3=new Inventory();
//			inventory3.setSkuCode("iphone_11");
//			inventory3.setQuantity(29);
//			
//			inventoryRepository.save(inventory1);
//			inventoryRepository.save(inventory2);
//			inventoryRepository.save(inventory3);
//		};
//	}

}
