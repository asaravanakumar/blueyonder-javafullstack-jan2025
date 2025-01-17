package com.examples.java.strings;

public class StringDemo {

	public static void main(String[] args) {

		char[] msg = { 'H', 'e', 'l', 'l', 'o' };

		String msg1 = "Hello World";
	
		String msg2 = new String("Hello World");
		
		// String concatination
//		String msg3 = msg1.concat(msg2);

		System.out.println(msg1 == msg2);
		System.out.println(msg1.length());
		System.out.println(msg1.charAt(5));
//
//		// Substring Example
//		System.out.println(msg1.substring(6, 11));

//		// String split
//		String[] msgs = msg1.split(",");
//		for (String token : msgs) {
//			System.out.println(token);
//		}
//
//		String source = "String,Tokenizer,Example";
//		StringTokenizer token = new StringTokenizer(source, ",");
//
//		System.out.println(token.countTokens());
//
//		while (token.hasMoreTokens()) {
//			System.out.println(token.nextToken());
//		}
//

//		StringBuilder strBuilder = new StringBuilder("Hello World");
//		strBuilder.append("Updated");
//		strBuilder.reverse();
//		System.out.println(strBuilder.toString());

//		StringBuffer strBuffer = new StringBuffer("Hello World");
//		strBuffer.append("Updated");
//		strBuffer.reverse();
//		System.out.println(strBuffer.toString());
	}
}
