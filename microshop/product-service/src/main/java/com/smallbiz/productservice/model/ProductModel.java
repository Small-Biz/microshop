package com.smallbiz.productservice.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductModel {
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
	
}
