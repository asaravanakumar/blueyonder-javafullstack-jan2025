package com.examples.spring.core.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.examples.spring.core.Greetings;

public class XmlBasedDepInjectionWithBeanFactoryEx01 {

	public static void main(String[] args) {

		// Creating IoC container supplying configuration file from classpath
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("beans-config.xml"));

		// Retrieving the bean from container
		Greetings obj = (Greetings) container.getBean("greetings");
		obj.setMessage("Instantiated BeanFactory based container supplying configuration from classpath.");

		// Display message
		obj.getMessage();

	}

}
