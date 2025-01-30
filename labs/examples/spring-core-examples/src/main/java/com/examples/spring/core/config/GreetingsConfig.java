package com.examples.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.examples.spring.core.Greetings;

@Configuration
public class GreetingsConfig {
	@Bean
	public Greetings greetings() {
		return new Greetings("Welcome to Spring Framework Training :) - Java based configuration example");
	}
}