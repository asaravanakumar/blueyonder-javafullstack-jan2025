package com.examples.scart.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examples.scart.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
