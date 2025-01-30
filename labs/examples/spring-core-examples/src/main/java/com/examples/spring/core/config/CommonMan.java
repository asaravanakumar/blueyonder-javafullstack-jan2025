package com.examples.spring.core.config;

import org.springframework.stereotype.Component;

public class CommonMan extends Person
{

	boolean canWalk;

	public CommonMan() {

	}

	public CommonMan(String name, int age, String location, boolean canWalk) {
		super(name, age, location);
		this.canWalk = canWalk;
	}

	public boolean isCanWalk() {
		return canWalk;
	}

	public void setCanWalk(boolean canWalk) {
		this.canWalk = canWalk;
	}


	
}
