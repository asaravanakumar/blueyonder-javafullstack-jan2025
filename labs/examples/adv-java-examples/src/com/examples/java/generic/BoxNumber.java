package com.examples.java.generic;

public class BoxNumber<N extends Number> {
	private N t;

	public void add(N t) {
		this.t = t;
	}

	public N get() {
		return t;
	}

	
	public static void main(String[] args) {
		// Raw Type
		BoxNumber<Integer> integerBox = new BoxNumber<>();
		
		integerBox.add(new Integer(10));
		// No casting required
		System.out.printf("Integer Value :%d\n\n", integerBox.get() + 10);

		BoxNumber<Double> doubleBox = new BoxNumber<>();

		doubleBox.add(new Double(10.0));
		// No casting required
		System.out.printf("Integer Value :%f\n\n", doubleBox.get() + 10);

//		BoxNumber<String> stringBox = new BoxNumber<>();
//		stringBox.add("Hello World");
//		// Able to perform String operations directly
//		System.out.printf("String Value :%s\n", stringBox.get().compareTo("Hello World"));
	}
}
