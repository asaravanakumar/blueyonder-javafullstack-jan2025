package com.examples.spring.cloud.provider;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudServiceRegistration {

//	@Value("${local.server.port}")
//	private String serverPort;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServiceRegistration.class, args);
	}

	@GetMapping("/")
	public String greeting(HttpServletRequest req) {
		return "Welcome to Product Service API - " + req.getRequestURL().toString();
	}

}
