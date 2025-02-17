package com.examples.scart.customer.service;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.examples.scart.customer.model.Customer;
import com.examples.scart.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;	
	
	/**
	 * @param customer
	 * @return
	 */
	public Integer add(Customer customer) {
		customerRepo.save(customer);
		return customer.getId();
	}

	public void update(Customer customer) {
		customerRepo.save(customer);
	}

	public Customer get(Integer id) {
		Optional<Customer> emp = customerRepo.findById(id); 
		return  emp.isPresent() ? emp.get() : null;
	}

	public void delete(Integer id) {
		customerRepo.deleteById(id);
	}

	public List<Customer> list() {
		return customerRepo.findAll();
	}
	
	public void deleteAll()
	{
		customerRepo.deleteAll();
	}
	
    @KafkaListener(topics = "ORDER_CREATED", groupId="customer-service")
    public void listenOrderApproval(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################Order Created: " + cr.value());

        String msg = (String) cr.value();
        String[] tokens = msg.split(",");
        String orderId = tokens[0];
        String customerId = tokens[1];
        String price = tokens[2];
        
        double dPrice = Double.valueOf(price);
        
        // Logic to check credit limit        
        Customer customer = customerRepo.findById(Integer.valueOf(customerId)).get();
        double availableCreditLimit = customer.getCreditLimit();
        if(availableCreditLimit >= dPrice) {
        	customer.setCreditLimit(availableCreditLimit - dPrice);
        	System.out.println("ORDER APPROVED :: " + orderId);
        	customerRepo.save(customer);
        	kafkaTemplate.send("ORDER_APPROVED", orderId);
        }
        else {
        	System.out.println("ORDER REJECTED :: " + orderId);
        	kafkaTemplate.send("ORDER_REJECTED", orderId);
        }        
    }	
}
