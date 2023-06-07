package com.smallbiz.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smallbiz.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
