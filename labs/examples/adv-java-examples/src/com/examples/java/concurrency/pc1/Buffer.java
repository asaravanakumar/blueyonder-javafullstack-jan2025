package com.examples.java.concurrency.pc1;

public class Buffer {
	private double value;
	private boolean hasValue;

	public double getValue() {
		hasValue = false;
		return value;
	}

	public void setValue(double value) {
		this.value = value;
		hasValue = true;
	}
	
	public boolean hasValue() {
		return hasValue;
	}
	
}
