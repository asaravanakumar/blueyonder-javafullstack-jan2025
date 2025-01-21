package com.examples.java.generic;

public class BoxGeneric<T> {
	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	
	public static void main(String[] args) {
		// Raw Type
		BoxGeneric<Integer> integerBox = new BoxGeneric<>();
		
		integerBox.add(new Integer(10));
		// No casting required
		System.out.printf("Integer Value :%d\n\n", integerBox.get() + 10);

		BoxGeneric<String> stringBox = new BoxGeneric<>();
		stringBox.add("Hello World");
		// Able to perform String operations directly
		System.out.printf("String Value :%s\n", stringBox.get().compareTo("Hello World"));
	}
}
