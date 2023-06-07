package com.smallbiz.orderservice.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemModel {
	private Long lineItemId;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;
}
