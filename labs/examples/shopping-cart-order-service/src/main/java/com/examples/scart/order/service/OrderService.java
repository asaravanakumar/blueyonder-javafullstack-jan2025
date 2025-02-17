package com.examples.scart.order.service;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.examples.scart.order.model.Order;
import com.examples.scart.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public Integer create(Order order) {
		order.setStatus("PEDNING");
		orderRepo.save(order);
		
		String msg = order.getId() + "," + order.getCustomerId() + "," + String.valueOf(order.getPrice());
		
		kafkaTemplate.send("ORDER_CREATED", msg);
		
		return order.getId();
	}

	public void update(Order order) {
		orderRepo.save(order);
	}

	public Order get(Integer empId) {
		Optional<Order> emp = orderRepo.findById(empId); 
		return  emp.isPresent() ? emp.get() : null;
	}

	public void delete(Integer empId) {
		orderRepo.deleteById(empId);
	}

	public List<Order> list() {
		return orderRepo.findAll();
	}
	
	public void deleteAll()
	{
		orderRepo.deleteAll();
	}
	
    @KafkaListener(topics = "ORDER_APPROVED", groupId="order-service")
    public void listenOrderApproval(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################Order Approved Received: " + cr.value());
        // Logic to update order with APPROVED status
        Integer approvedOrderId = new Integer(cr.value().toString());
        Order order = orderRepo.findById(approvedOrderId).get();
        order.setStatus("APPROVED");
        
        // Save Order
        orderRepo.save(order);
    }
    
    @KafkaListener(topics = "ORDER_REJECTED", groupId="order-service")
    public void listenOrderRejection(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################Order Rejected Received: " + cr.value());
        // Logic to update order with REJECTED status
        Integer rejectedOrderId = new Integer(cr.value().toString());
        Order order = orderRepo.findById(rejectedOrderId).get();
        order.setStatus("REJECTED");
        
        // Save Order
        orderRepo.save(order);
    }    
}
