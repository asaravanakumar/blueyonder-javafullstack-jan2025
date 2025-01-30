package com.examples.spring.core.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("customer")
@Lazy(true)
@Scope("singleton")
public class Customer {
	
	@Autowired(required=false)
	@Qualifier("commonMan")
	private Person person;
	
	public Customer()
	{
		
	}
	
//	@Autowired
	public Customer(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	//@Required
	public void setPerson(Person person) {
		this.person = person;
	}

}
