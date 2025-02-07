package com.labs.orderapp.service;

import com.labs.orderapp.model.Order;
import com.labs.orderapp.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

public class OrderServiceJpaRepoImpl implements OrderService {

    @Autowired
    OrderRepository orderRepo;

    @Override
    public int createOrder(Order order) {
        return orderRepo.save(order).getId() ;
    }

    @Override
    public Collection<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrder(int id) {
        return orderRepo.findById(id).orElse(null);
    }

    @Override
    public boolean updateOrder(int id, Order order) {
         if(orderRepo.existsById(id)) {
             return orderRepo.save(order) != null;
         }
         else return false;
    }

    @Override
    public boolean deleteOrder(int id) {
         if(orderRepo.existsById(id)) {
             orderRepo.deleteById(id);
             return true;
         }
         return false;
    }
}
