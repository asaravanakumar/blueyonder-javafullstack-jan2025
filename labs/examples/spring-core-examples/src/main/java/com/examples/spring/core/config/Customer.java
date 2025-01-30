package com.examples.spring.core.config;

public class Customer {
	private Person person;
	
	public Customer()
	{
		
	}

	public Customer(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
