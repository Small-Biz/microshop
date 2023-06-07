package com.smallbiz.orderservice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.smallbiz.orderservice.entity.Order;
import com.smallbiz.orderservice.entity.OrderLineItem;
import com.smallbiz.orderservice.event.PlaceOrderEvent;
import com.smallbiz.orderservice.message.CheckInventoryResponse;
import com.smallbiz.orderservice.message.PlaceOrderRequest;
import com.smallbiz.orderservice.model.OrderLineItemModel;
import com.smallbiz.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;
	private final WebClient.Builder webClientBuilder;	
	private final KafkaTemplate<String,PlaceOrderEvent> kafkaTemplate;
	
	public String placeOrder(PlaceOrderRequest request) {
		Order order=new Order();
		order.setReferenceNumber(UUID.randomUUID().toString());
		
		order.setLineItems( request.getItemList().stream().map(this::mapToEntity).collect(Collectors.toList()));
		
		List<String>skuCodeList=order.getLineItems().stream().map(item->item.getSkuCode()).collect(Collectors.toList());
		
		//after checking enough inventory, then place order
		CheckInventoryResponse response=webClientBuilder.build().get()
		.uri("http://inventory-service/api/inventory",
				uriBuilder->uriBuilder.queryParam("skuCode", skuCodeList).build())
		.retrieve().bodyToMono(CheckInventoryResponse.class)
		.block();
		
		boolean allProductInStock=response.getInventoryList().stream().allMatch(item->item.isInStock());
		
		if (allProductInStock) {
			orderRepository.save(order);
			kafkaTemplate.send("placeOrderNotification", new PlaceOrderEvent(order.getReferenceNumber()));
			return "Place Order Successfully";
		}else {
			throw new IllegalArgumentException("Product is not in stock");
		}
	}
	
	private OrderLineItem mapToEntity( OrderLineItemModel model) {
		
		OrderLineItem entity=new OrderLineItem();
		entity.setSkuCode(model.getSkuCode());
		entity.setPrice(model.getPrice());
		entity.setQuantity(model.getQuantity());
		
		return entity;
		
	}
}
