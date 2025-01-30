package com.examples.spring.core.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("superMan")
@Primary
public class SuperMan extends Person
{

	boolean canFly;

	public SuperMan() {

	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}


	
}
