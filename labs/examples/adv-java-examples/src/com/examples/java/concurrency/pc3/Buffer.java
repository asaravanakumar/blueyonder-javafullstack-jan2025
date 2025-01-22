package com.examples.java.concurrency.pc3;

import java.util.LinkedList;

public class Buffer {
	private int capacity;
	private LinkedList<Double> valueList;

	public Buffer(int c) {
		capacity = c;
		valueList = new LinkedList<Double>();
	}
	
	public synchronized double getValue() {
		if(hasValue()) {
			return valueList.removeFirst();
		} else {
			throw new RuntimeException("No value available in buffer"); 
		}
	}

	public synchronized void setValue(double value) {
		if(isFull()) {
			throw new RuntimeException("Buffer is full"); 
		} else {
			valueList.add(value);
		}
	}
	
	public boolean hasValue() {
		return valueList.size() != 0;
	}
	
	public boolean isFull() {
		return valueList.size() == capacity;
	}
	
}
