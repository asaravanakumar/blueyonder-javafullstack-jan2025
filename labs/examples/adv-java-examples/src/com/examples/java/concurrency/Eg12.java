package com.examples.java.concurrency;

/**
 * Thread examples
 * Thread Priority
 */
public class Eg12 {
	public class CpuInternsiveJob extends Thread {
		
		public CpuInternsiveJob(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " starting >>>");
			System.out.flush();
			int x;			
			for(int i=0; i <100000; i++) {
				for(int j=0; j<100000; j++) {
					 x = i + j;
				}
			}
			System.out.println(Thread.currentThread().getName() + " stopping");
			System.out.flush();
		}
	}
	
	public static void main(String[] args) {
		Eg12 e = new Eg12();
		Thread t1 = e.new CpuInternsiveJob("t1");
		Thread t2 = e.new CpuInternsiveJob("t2");
		Thread t3 = e.new CpuInternsiveJob("t3");
		
		Thread t4 = e.new CpuInternsiveJob("t4");
		Thread t5 = e.new CpuInternsiveJob("t5");
		Thread t6 = e.new CpuInternsiveJob("t6");

		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);
		
		t4.start();
		t5.start();
		t6.start();

		t1.start();
		t2.start();
		t3.start();
	}
}
