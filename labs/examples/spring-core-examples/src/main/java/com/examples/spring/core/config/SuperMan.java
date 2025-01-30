package com.examples.spring.core.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public class SuperMan extends Person
{

	boolean canFly;

	public SuperMan() {

	}
	public SuperMan(String name, int age, String location, boolean canFly) {
		super(name, age, location);
		this.canFly = canFly;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}


	
}
