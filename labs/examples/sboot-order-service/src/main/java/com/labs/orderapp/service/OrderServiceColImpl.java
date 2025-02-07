package com.labs.orderapp.service;

import com.labs.orderapp.model.Order;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
public class OrderServiceColImpl implements OrderService {
    private Map<Integer, Order> orders = new HashMap<>();
    private static int COUNTER = 0;

    @Override
    public int createOrder(Order order) {

//        if (order.getCategory().isBlank() || order.getPrice() < 0) {
//            throw new IllegalArgumentException("Invalid order data");
//        }

        order.setId(++COUNTER);
        orders.put(order.getId(), order);
        return order.getId();
    }

    @Override
    public Collection<Order> getAllOrders() {
        return orders.values();
    }

    @Override
    public Order getOrder(int id) {
        return orders.get(id);
    }

    @Override
    public boolean updateOrder(int id, Order order) {
        return orders.containsKey(id) && orders.replace(id, order)!=null;
    }

    @Override
    public boolean deleteOrder(int id) {
        return orders.remove(id)!=null;
    }
}
