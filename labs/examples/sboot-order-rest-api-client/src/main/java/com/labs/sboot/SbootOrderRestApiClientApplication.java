package com.labs.sboot;

import com.labs.sboot.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@SpringBootApplication
public class SbootOrderRestApiClientApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(SbootOrderRestApiClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SbootOrderRestApiClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// STEP 1: Create REST Template / Client
		// STEP 2: Construct and Send Request
		// STEP 3: Receive Response and Print Details

		// Approach #1: Rest Template

		RestTemplate restTemplate = new RestTemplate();

		String baseUrl = "http://localhost:9090/orders";

		// GET ALL - Object
		Object response = restTemplate.getForObject(baseUrl, Object.class);
		log.info("Response: " + response.toString());

		// GET ALL - Entity
		ResponseEntity resEntity = restTemplate.getForEntity(baseUrl, Object.class);
		log.info("Response Status: {}", resEntity.getStatusCode());
		log.info("Response Headers Count: {}", resEntity.getHeaders().size());
		log.info("Response Body: {}", resEntity.getBody());

		// GET SPECIFIC - ENTITY
		ResponseEntity<Order> resEntity1 = restTemplate.getForEntity(baseUrl + "/1", Order.class);
		log.info("Response Status: {}", resEntity1.getStatusCode());
		log.info("Response Headers Count: {}", resEntity1.getHeaders().size());
		log.info("Response Body: {}", resEntity1.getBody().getDescription());

		// CREATE ENTITY

		Order order1 = new Order();
		order1.setCategory("Laptops");
		order1.setDescription("Dell Inspiron");
		order1.setQuantity(10);
		order1.setPrice(60000.0);

		ResponseEntity resPost = restTemplate.postForEntity(baseUrl, order1, Object.class);
		log.info("ORDER CREATE - Response Status {}", resPost.getStatusCode());
		log.info("ORDER CREATE - Response {}", resPost.getBody());


		// Approach #2: Rest Client

//		RestClient restClient = RestClient.create(baseUrl);
//
//		Object getAllResponse = restClient
//									.get()
//									.retrieve()
//									.body(Object.class);
//
//		Order order2 = new Order();
//		order2.setCategory("Laptops");
//		order2.setDescription("HP Pavilion");
//		order2.setQuantity(5);
//		order2.setPrice(70000.0);
//
//		Object postReponse = restClient
//				.post()
//				.body(order2)
//				.retrieve()
//				.body(Object.class);
//
//		log.info("ORDER CREATE - Response {}", postReponse);
//
//		List<Order> ordersList = restClient
//				.get()
//				.retrieve()
//				.body(new ParameterizedTypeReference<List<Order>>() {
//				});
//
//		log.info("RestClient Response - OrdersList: {}", ordersList);
	}
}
