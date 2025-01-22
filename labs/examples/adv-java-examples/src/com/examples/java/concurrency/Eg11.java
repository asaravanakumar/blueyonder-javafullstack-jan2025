package com.examples.java.concurrency;

import com.examples.java.concurrency.pc6.Buffer;
import com.examples.java.concurrency.pc6.Consumer;
import com.examples.java.concurrency.pc6.Producer;

/**
 * Thread Example
 * Producer Consumer using Lock & Condition
 */
public class Eg11 {
	public static void main(String[] args) {
		Buffer b = new Buffer(5);
		Consumer c = new Consumer(b);
		Producer p = new Producer(b);
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(p);
		t1.start();
		t2.start();
		try {
			Thread.sleep(10000);
			t1.interrupt();
			t2.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
