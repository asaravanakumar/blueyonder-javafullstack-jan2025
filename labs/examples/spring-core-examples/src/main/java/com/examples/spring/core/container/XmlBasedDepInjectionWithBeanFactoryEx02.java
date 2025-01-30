package com.examples.spring.core.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.examples.spring.core.Greetings;

public class XmlBasedDepInjectionWithBeanFactoryEx02 {

	public static void main(String[] args) {

		// Creating IoC container supplying configuration file from file system
		BeanFactory container = new XmlBeanFactory(new FileSystemResource("src/main/resources/beans-config.xml"));

		// Retrieving the bean from container
		Greetings obj = (Greetings) container.getBean("greetings");
		obj.setMessage("Instantiated BeanFactory based IoC container supplying configuration from file system.");

		// Display message
		obj.getMessage();

	}

}
