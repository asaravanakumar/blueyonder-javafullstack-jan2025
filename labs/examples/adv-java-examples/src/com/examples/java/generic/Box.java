package com.examples.java.generic;

public class Box {
	private Object obj;

	public void add(Object obj) {
		this.obj = obj;
	}

	public Object get() {
		return obj;
	}

	public static void main(String[] args) {
		Box box = new Box();	

		// works
		box.add(new Integer(10));
		System.out.printf("Integer Value :%d\n\n", box.get());
		
		// works
		box.add(new String("Hello World"));
		System.out.printf("String Value :%s\n", box.get() );
		
		// works fine
		box.add(new Integer(10));
		System.out.printf("Integer Value :%d\n\n", (Integer) box.get() + 10);
		
		// will throw ClassCastException at runtime 
		box.add(new Double(10));
		System.out.printf("Integer Value :%d\n\n", (Integer) box.get() + 10);
	}
}
