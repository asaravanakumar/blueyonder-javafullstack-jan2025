package com.examples.java.wrapper;

public class PrimitiveWrapperDemo {
	public static void main(String[] args) {
		int a = 100; // stack -> 4 bytes

		Integer b = new Integer(100); // heap -> 4 + 2 -> 6 bytes

		Integer c = b;

//		a = (int) b;

//		a = b;

//		a = b.intValue();

		b = Integer.valueOf(a);

		System.out.println(a);
	}
}
