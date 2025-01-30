package com.examples.spring.core.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AnnotationBasedDepedencyInjectionEx02 {

	public static void main(String[] args) {
		// Assemble the objects
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfiguration.class);

		Customer obj = (Customer) context.getBean("customer");
		System.out.println("Customer: " + obj);
		System.out.println("Dependent Person: " + obj.getPerson());

		Person obj1 = (Person) context.getBean("commonMan");
		System.out.println("CommonMan: " + obj1);
		
		Person obj2 = (Person) context.getBean("superMan");
		System.out.println("SuperMan: " + obj2);
		
//		obj.getPerson().setName("Anand");
//		obj.getPerson().setAge(40);
//		obj.getPerson().setLocation("Cochin");
		
		System.out.println(
				obj.getPerson().getName() + " " + obj.getPerson().getAge() + " " + obj.getPerson().getLocation());		

		context.registerShutdownHook();
	}
}
