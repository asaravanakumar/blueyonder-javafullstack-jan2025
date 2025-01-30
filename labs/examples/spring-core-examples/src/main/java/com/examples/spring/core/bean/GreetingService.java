package com.examples.spring.core.bean;

public class GreetingService {

	private String message = "Hello World from Greeting Service";
	private static GreetingService greetingService;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}

	// Static Factory method to create GreetingService instance
	public static GreetingService getInstance() {
		if (greetingService == null)
		{
			greetingService = new GreetingService();
//			greetingService.setMessage("Hello World from Greeting Service - Static Factory Method Example");
		}
		return greetingService;
	}

	// Overloaded Static Factory method with argument
	public static GreetingService getInstance(String message) {
		if (greetingService == null)
		{
			greetingService = new GreetingService();
			greetingService.setMessage(message);
		}
		return greetingService;
	}

}
