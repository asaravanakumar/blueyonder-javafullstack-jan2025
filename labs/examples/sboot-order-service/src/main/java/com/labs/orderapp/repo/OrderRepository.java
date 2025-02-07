package com.labs.orderapp.repo;

import com.labs.orderapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {// extends JpaRepository<Order, Integer> extends CrudRepository<Order, Integer>{
}
