package com.examples.java.arrays;

public class MultiDimArrayDemo {
	public static void main(String[] args) {
		// Array Declaration, Instantiation
		int[][] nos = new int[3][3];
		
		nos[0][0] = 10;
		nos[0][1] = 20;
		nos[0][2] = 30;
		
		nos[1][0] = 100;
		nos[1][1] = 200;
		nos[1][2] = 300;
		
		// Row 1 Col 1
//		System.out.println(nos[0][0]);
		
		// Row 2 Col 1
//		System.out.println(nos[1][0]);
		
		for(int[] rows: nos) {
			for(int item: rows) {
				System.out.println(item);
			}
		}
		
	}

}
