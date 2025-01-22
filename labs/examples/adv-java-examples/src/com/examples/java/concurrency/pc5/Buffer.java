package com.examples.java.concurrency.pc5;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private int capacity;
	private LinkedList<Double> valueList;
	private Lock lock = new ReentrantLock();

	public Buffer(int c) {
		capacity = c;
		valueList = new LinkedList<Double>();
	}
	
	public double getValue() {
		if(hasValue()) {
			lock.lock();
			try {
				return valueList.removeFirst();
			} finally {
				lock.unlock();
			}
		} else {
			throw new RuntimeException("No value available in buffer"); 
		}
	}

	public void setValue(double value) {
		if(isFull()) {
			throw new RuntimeException("Buffer is full"); 
		} else {
			lock.lock();
			try {
				valueList.add(value);
			} finally {
				lock.unlock();
			}
		}
	}
	
	public boolean hasValue() {
		return valueList.size() != 0;
	}
	
	public boolean isFull() {
		return valueList.size() == capacity;
	}
	
}
