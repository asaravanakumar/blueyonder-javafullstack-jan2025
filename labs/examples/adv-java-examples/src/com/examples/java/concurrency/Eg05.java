package com.examples.java.concurrency;

import com.examples.java.concurrency.pc1.Buffer;
import com.examples.java.concurrency.pc1.Consumer;
import com.examples.java.concurrency.pc1.Producer;

/**
 * Thread Example
 * Producer Consumer using wait & notify
 */
public class Eg05 {
	public static void main(String[] args) {
		Buffer b = new Buffer();
		Consumer c = new Consumer(b);
		Producer p = new Producer(b);
		
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(p);
		t1.start();
		t2.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		t2.interrupt();
	}
}
