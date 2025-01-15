package com.examples.java.core.varargs;

public class VarArgsDemo {
	
	/*
	public static int sum(int a, int b)
	{
		return a + b;
	}	
	
	public static int sum(int a, int b, int c, int d)
	{
		return a + b + c + d;
	}*/
	
	/*
	 * Variable arguments declaration
	 */
	public static int sum(int... args)
	{
		int total = 0;
		for(int arg: args)
		{
			total += arg;
		}
		return total;
	}	
	
	public static void main(String[] args)
	{
		System.out.println(sum(10, 40));
	}

}
