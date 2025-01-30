package com.examples.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car { //implements InitializingBean, DisposableBean {

	private String color;
	private String model;
	private String manufacturer;
	private Engine engine;
	
	public Car() {
		System.out.println("Car default constructor called...");
	}
	
	public Car(Engine engine) {
		System.out.println("Car constructor called..");
		this.engine = engine;
	}
	
//	public static Car createInstance(Engine engine) {
//		Car car = new Car(engine);
//		return car;
//	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		System.out.println("Car setter called..");
		this.engine = engine;
	}
	
//	public void init() {
//		System.out.println("Car Bean Initialized...");
//	}
//	
//	public void destroy() {
//		System.out.println("Car Bean Destroyed...");
//	}
	
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("Car Bean Initialized...");		
//	}
//
//	public void destroy() throws Exception {
//		System.out.println("Car Bean Destroyed...");		
//	}
}
