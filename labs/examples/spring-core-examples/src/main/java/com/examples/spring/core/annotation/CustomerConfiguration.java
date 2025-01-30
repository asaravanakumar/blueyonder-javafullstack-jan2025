package com.examples.spring.core.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.examples.spring.core.annotation"})
class CustomerConfiguration 
{
// Recommended to use @Configuration to define beans like below
//    @Bean
//    public Customer customer() {
//        return new Customer(person());
//    }    
//    
//    @Bean
//    public Person person() {
//        return new Person("Bill",36,"San Jose");
//    }    
}
