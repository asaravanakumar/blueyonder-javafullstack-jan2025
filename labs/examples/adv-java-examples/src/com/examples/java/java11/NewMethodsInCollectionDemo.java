package com.examples.java.java11;

import java.util.Arrays;
import java.util.List;

public class NewMethodsInCollectionDemo {

	public static void main(String[] args) {
		// toArray method which takes an IntFunction argument.
		List<String> sampleList = Arrays.asList("Java", "Kotlin");
		// prior to Java 11
//		String[] sampleArray = sampleList.toArray(new String[sampleList.size()]);
		// Java 11
		String[] sampleArray = sampleList.toArray(String[]::new);
		Arrays.stream(sampleArray).forEach(System.out::println);
	}

}
