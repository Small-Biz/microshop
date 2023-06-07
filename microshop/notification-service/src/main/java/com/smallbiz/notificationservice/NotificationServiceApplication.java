package com.smallbiz.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.smallbiz.notificationservice.event.PlaceOrderEvent;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}	
	
	@KafkaListener(topics="placeOrderNotification", groupId = "groudIdName")
	public void handleNotification(PlaceOrderEvent event ) {
		log.info("Received Notification for Order - {}", event.getOrderNumberString());
	}
}
