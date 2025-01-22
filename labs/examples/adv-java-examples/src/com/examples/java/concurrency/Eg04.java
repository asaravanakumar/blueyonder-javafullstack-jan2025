package com.examples.java.concurrency;

/**
 * Thread Example
 * Join
 */
public class Eg04 {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
				for(int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " - " + i);
		//			try {
		//				Thread.sleep(1000);
		//			} catch (InterruptedException e) {
		//				e.printStackTrace();
		//			}
				}
				System.out.println(Thread.currentThread().getName() + " -->Stop thread");
			}
		};
		
		Thread t = new Thread(r);
		t.start();

		try {
			t.join();	// underlying thread should wait until this thread terminates
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}

		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
