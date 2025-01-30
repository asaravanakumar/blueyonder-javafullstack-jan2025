package com.examples.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(GreetingsConfig.class)	// import other configuration class
class CustomerConfiguration 
{
    @Bean
    public Customer customer() {
        Customer customer = new Customer(person());	// constructor injection
        // setter injection
//        customer.setPerson(person());
        return customer;
    }
    
    @Bean
    public Person person() {
        return new Person("Jack",50,"New York");
    }
}
