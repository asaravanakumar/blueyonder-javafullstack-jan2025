package com.examples.java.core.datatypes;

/**
 * Java Data Types Overview
 */
public class DataTypesDemo {

	// Constant declaration
	static final int NO_OF_MONTHS_IN_YEAR = 12;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		// Data Types => Primitive and Non-Primitive
		// Primitive => byte, short, int, long, float, double, char, boolean

		// 1 byte - 8 bits -> 2^8 -> 256
		byte bmin = -128;
		byte bmax = 127;

		// 2 bytes - 16 bits -> 2^16 -> 65536
		short smin = -32768;
		short smax = 32767;

		// 4 bytes - 32 bits -> 2^32 -> 4294967296
		int imin = -2147483648;
		int imax = 2147483647;

		// 8 bytes - 64 bits -> 2^64 -> 18446744073709551616
		long lmin = -9223372036854775808L;
		long lmax = 9223372036854775807L;

		// min - 1.4E-45; max - 3.4028235E38
		float fvalue = 4294967296.55f; // 4 bytes

		// min - 4.9E-324; max - 1.7976931348623157E308
		double dvalue = 4324353453454294967296.5563458888888888876f; // 8 bytes

		char e = 'a'; // 2 bytes

		boolean flag = true; // 1 bit

		// Non-primitive Data Types => Arrays, String, Object
		
		String helloWorldMsg = "Hello Java";

		// Variable Types
		// 1) Primitive Variable
		// 2) Reference Variable

		System.out.println(NO_OF_MONTHS_IN_YEAR);
	}
}
