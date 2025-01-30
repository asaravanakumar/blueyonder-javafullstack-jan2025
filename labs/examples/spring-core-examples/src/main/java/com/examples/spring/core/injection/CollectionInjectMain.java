package com.examples.spring.core.injection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionInjectMain {

	public static void main(String[] args) {
		
		// Instantiating the container
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
				
		CollectionInjectionEx obj = (CollectionInjectionEx) context.getBean("collectionInjectionEx");
		
		obj.getAddressList();
		obj.getAddressSet();
		obj.getAddressMap();
		obj.getAddressProp();
		
		context.registerShutdownHook();
		
	}

}
