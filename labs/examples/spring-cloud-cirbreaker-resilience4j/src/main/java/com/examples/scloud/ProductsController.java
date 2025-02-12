package com.examples.scloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@RestController
public class ProductsController {

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping("/products1")
    public String greetings() throws URISyntaxException {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "http://localhost:9090/products";

        RestTemplate restTemplate = new RestTemplate();

        return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class),
                throwable -> fallBackMethod());
    }

    public String fallBackMethod() {
        return "Server Busy. Please try again after sometime!!!";
    }
}
