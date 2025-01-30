package com.examples.spring.core.bean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Example for bean instantiation with instance factory method.
 */
public class BeanInstantiationInstanceFactoryEx {

	public static void main(String[] args) {

		// Creating IoC container supplying configuration file from classpath
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");

		// Retrieving the bean from container
		GreetingService obj = (GreetingService) context.getBean("greetingService");
		AccountService obj1 = (AccountService) context.getBean("accountService");

		// Display message
		System.out.println(obj.getMessage());
		System.out.println(obj1.getMessage());

		// Graceful shutdown of container
		context.registerShutdownHook();

	}

}
