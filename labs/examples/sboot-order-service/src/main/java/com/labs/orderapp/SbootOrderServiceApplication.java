package com.labs.orderapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
// @Configuration
// @ComponentScan(basePackages = {"com.labs.orderapp"})
// @EnableAutoConfiguration
public class SbootOrderServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SbootOrderServiceApplication.class, args);
		log.info("No of beans: {}", ctx.getBeanDefinitionCount());
//		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
	}
}
