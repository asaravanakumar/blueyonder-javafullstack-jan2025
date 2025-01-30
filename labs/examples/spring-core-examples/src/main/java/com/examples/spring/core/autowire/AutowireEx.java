package com.examples.spring.core.autowire;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireEx {

	public static void main(String[] args) {
		
		// Instantiating the container
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
				
		Customer obj = (Customer) context.getBean("customer");
		System.out.println(obj.getPerson().getName() + " " + obj.getPerson().getAge() + " " + obj.getPerson().getLocation());
		
		context.registerShutdownHook();
		
	}

}
