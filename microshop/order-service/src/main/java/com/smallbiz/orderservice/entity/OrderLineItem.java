package com.smallbiz.orderservice.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="order_line_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long lineItemId;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;
}
