package com.examples.scart.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShoppingCartRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartRegistryApplication.class, args);
	}

}
