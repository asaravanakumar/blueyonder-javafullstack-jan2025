package com.examples.scart.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.query.Param;

import com.examples.scart.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public List<Customer> findByName(String name);

	public List<Customer> findByPrimeAndLocation(boolean prime, String location);

//	@Query("select e from Customer e where e.location = :location")
//	public List<Customer> findByTypeQuery(@Param("location") String location);
}
