package com.smallbiz.orderservice.message;

import java.util.List;

import com.smallbiz.orderservice.model.OrderLineItemModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderRequest {

	private List<OrderLineItemModel> itemList;
}
