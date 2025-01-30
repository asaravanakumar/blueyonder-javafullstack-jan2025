package com.examples.spring.core.annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBasedDepedencyInjectionEx01 {

	public static void main(String[] args) {
		// Assemble the objects
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation-config.xml");
		
		Customer obj = (Customer) context.getBean("customer");
		System.out.println("Customer: " + obj);
		System.out.println("Dependent Person: " + obj.getPerson());

//		Person obj1 = (Person) context.getBean("person");
//		System.out.println("Person: " + obj1);
		
		obj.getPerson().setName("Anand");
		obj.getPerson().setAge(40);
		obj.getPerson().setLocation("Cochin");
		
		System.out.println(
				obj.getPerson().getName() + " " + obj.getPerson().getAge() + " " + obj.getPerson().getLocation());
		
		context.registerShutdownHook();
	}
}
