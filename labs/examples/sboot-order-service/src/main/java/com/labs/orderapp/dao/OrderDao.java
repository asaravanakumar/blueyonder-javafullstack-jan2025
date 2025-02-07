package com.labs.orderapp.dao;

import com.labs.orderapp.model.Order;

import java.util.Collection;

public interface OrderDao {

    public int createOrder(Order order);

    public Collection<Order> getAllOrders();

    public Order getOrder(int id);

    public boolean updateOrder(int id, Order order);

    public boolean deleteOrder(int id);
}
