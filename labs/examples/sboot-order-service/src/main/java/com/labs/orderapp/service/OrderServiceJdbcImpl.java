package com.labs.orderapp.service;

import com.labs.orderapp.dao.OrderDao;
import com.labs.orderapp.dao.OrderDaoJdbcImpl;
import com.labs.orderapp.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

//@Service
@AllArgsConstructor
public class OrderServiceJdbcImpl implements OrderService {

//    @Autowired
    OrderDao orderDao;

//    public OrderServiceJdbcImpl(OrderDaoJdbcImpl orderDao) {
//        this.orderDao = orderDao;
//    }

    @Override
    public int createOrder(Order order) {
        return orderDao.createOrder(order);
    }

    @Override
    public Collection<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public Order getOrder(int id) {
        return orderDao.getOrder(id);
    }

    @Override
    public boolean updateOrder(int id, Order order) {
        return orderDao.updateOrder(id, order);
    }

    @Override
    public boolean deleteOrder(int id) {
        return orderDao.deleteOrder(id);
    }
}
