package com.examples.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringMain {

	public static void main(String[] args) {

		// Instantiating the container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");

		// Access bean from container
		Greetings obj =  context.getBean("greetings", Greetings.class);
		obj.getMessage();

		// Graceful shutdown of container, preferred for stand alone apps
		context.registerShutdownHook();

		// Graceful shutdown of container, has same effect as thing as
		// registering shutdown hook, but not be called when JVM goes down
		// before reaching this statement
		// context.close();

	}

}
