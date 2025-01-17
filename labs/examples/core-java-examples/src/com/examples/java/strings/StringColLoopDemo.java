package com.examples.java.strings;

public class StringColLoopDemo {

	public static void main(String[] arg) {
		String phrase = "The quick brown fox jumped over the lazy dog.";
		int vowels = 0;
		for (char ch : phrase.toCharArray()) {
			ch = Character.toLowerCase(ch);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				++vowels;
			}
		}
		System.out.println("The phrase contains " + vowels + " vowels.");
	}

}
