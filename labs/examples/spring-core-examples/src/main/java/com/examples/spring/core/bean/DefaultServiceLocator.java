package com.examples.spring.core.bean;

public class DefaultServiceLocator {
	
	GreetingService greetingService = new GreetingService();
	AccountService accountService = new AccountService();
	
	public GreetingService createGreetingService()
	{
		return greetingService;
	}
	
	public AccountService createAccountService()
	{
		return accountService;
	}	

}
