package com.examples.spring.core.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.spring.core.Greetings;

/**
 * Example for bean instantiation with constructor arguments.
 */
public class BeanInstantiationConstructorArgResolutionEx {

	public static void main(String[] args) {

		// Creating IoC container supplying configuration file from classpath
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");

		// Retrieving the bean from container
		Greetings obj = (Greetings) context.getBean("greetings2");

		// Display message
		obj.getMessage();

		// Graceful shutdown of container
		context.registerShutdownHook();

	}

}
