package com.examples.java.concurrency;

import com.examples.java.concurrency.pc2.Buffer;
import com.examples.java.concurrency.pc2.Consumer;
import com.examples.java.concurrency.pc2.Producer;

/**
 * Thread Example
 * Producer Consumer using synchronized
 */
public class Eg06 {
	public static void main(String[] args) {
		Buffer b = new Buffer(5);
		Consumer c = new Consumer(b);
		Producer p = new Producer(b);
		Thread t1 = new Thread(c,"c");
		Thread t2 = new Thread(p,"p");
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
