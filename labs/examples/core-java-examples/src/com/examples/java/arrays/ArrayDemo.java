package com.examples.java.arrays;

public class ArrayDemo {

	public static void main(String[] args)
	{
		// Array -> store the data sequentially
		// Approach #1
		// Declaration, Initialization
		int[] nos = {10,20,30};  // -> 4 * 3 -> 12 bytes + 2 bytes for ref variable mem allocated
		
		// Approach #2
		// Declaration, Instantiation, Initialization
		//int[] nos = new int[] {10, 20, 30};
		
		// Approach #3
		// Declaration, Instantiation
		// int[] nos = new int[3];
		// nos[0] = 10;
		// nos[1] = 20;
		// nos[2] = 30;
		
		//System.out.println(nos[0]);	// first
		//System.out.println(nos[nos.length-1]); // last

		for(int i =0; i < nos.length; i++)
		{
			System.out.println(nos[i]);
		}

		// for each
//		for(int i: nos)
//		{
//			System.out.println(i);
//		}

	}
}
