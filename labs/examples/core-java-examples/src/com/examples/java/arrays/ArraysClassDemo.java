package com.examples.java.arrays;

import java.util.Arrays;

public class ArraysClassDemo {

	public static void main(String[] args) {
		int[] test = new int[5];

		// filling values
		Arrays.fill(test, 100);
		test[0] = 30;
		test[1] = 50;
		test[2] = 20;

		for (int i : test) {
			System.out.println(i);
		}


//		int[] test1 = Arrays.copyOf(test, 5);
//
//		for (int i : test1) {
//			System.out.println(i);
//		}
//
//		// Merge Sort
//		Arrays.parallelSort(test);
//
//		// Quick Sort
//		Arrays.sort(test);
//
//		for (int i : test) {
//			System.out.println(i);
//		}
//
//		// binary search
//		int[] test2 = new int[4];
//		test2[0] = 10;
//		test2[1] = 20;
//		test2[2] = 30;
//		test2[3] = 20;
//		int index = Arrays.binarySearch(test, 30);
//		System.out.println(index);
	}

}
