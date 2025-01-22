package com.examples.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsoleDataWithStreamEx {

	public static void main(String args[]) throws IOException {
		BufferedReader cin = null;		

		try {
			
			cin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter characters, 'q' to quit.");
			String line;
			do {
				line = (String) cin.readLine();
				System.out.println(line);
			} while (line != "q");
		} finally {
			if (cin != null) {
				cin.close();
			}
		}
	}
}
 


