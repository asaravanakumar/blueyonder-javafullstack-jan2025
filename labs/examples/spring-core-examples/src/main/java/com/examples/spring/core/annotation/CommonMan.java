package com.examples.spring.core.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("commonMan")
public class CommonMan extends Person
{

	boolean canWalk;

	public CommonMan() {

	}

	public boolean isCanFly() {
		return canWalk;
	}

	public void setCanFly(boolean canFly) {
		this.canWalk = canFly;
	}


	
}
