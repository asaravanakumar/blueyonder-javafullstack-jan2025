package com.examples.java.concurrency.pc6;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private int capacity;
	private LinkedList<Double> valueList;
	private Lock lock = new ReentrantLock();
	private Condition isNotFull = lock.newCondition();
	private Condition isNotEmpty = lock.newCondition();

	public Buffer(int c) {
		capacity = c;
		valueList = new LinkedList<Double>();
	}
	
	public double getValue() {
		try {
			while(!hasValue()) {
				isNotEmpty.await();
			}
			lock.lock();
			double returnValue = valueList.removeFirst();
			isNotFull.signal();
			return returnValue;
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted");
			throw new RuntimeException("Thread interrupted");
		} finally {
			lock.unlock();
		}
	}

	public void setValue(double value) {
		try {
			while(isFull()) {
				isNotFull.await();
			}
			lock.lock();
			valueList.add(value);
			isNotEmpty.signal();
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted");
			throw new RuntimeException("Thread interrupted");
		} finally {
			lock.unlock();
		}
	}
	
	public boolean hasValue() {
		return valueList.size() != 0;
	}
	
	public boolean isFull() {
		return valueList.size() == capacity;
	}
	
}
