package com.examples.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericConfig {

	@Bean
	public Person person() {
		return new Person("Sanjay", 30, "Pune");
	}
}
