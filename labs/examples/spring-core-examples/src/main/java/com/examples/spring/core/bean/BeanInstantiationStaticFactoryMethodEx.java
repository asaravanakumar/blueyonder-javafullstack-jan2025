package com.examples.spring.core.bean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Example for bean instantiation with static factory method.
 */
public class BeanInstantiationStaticFactoryMethodEx {

	public static void main(String[] args) {

		// Creating IoC container supplying configuration file from classpath
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");

		// Retrieving the bean from container
		GreetingService obj = (GreetingService) context.getBean("greetingServiceFactory");

		// Display message
		System.out.println(obj.getMessage());

		// Graceful shutdown of container
		context.registerShutdownHook();

	}

}
