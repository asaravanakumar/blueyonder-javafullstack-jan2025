package com.examples.java.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionEx {

	public static void main(String[] args)  {

		try {
			compute();
			importFile();
		} catch (CustomException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

		System.out.println("Processing completed");

		// System.out.println(countries[4]);
	}
	
	public static void compute() throws CustomException
	{
		// throws arithmetic exception
		 try {
			 int a = 10 / 0;
			 System.out.println(a);
		 }catch(ArithmeticException ae) {
			 throw new CustomException("Can't divide by Zero: " + ae.getMessage(), ae);
		 }
		
		// throws custom exception
//		throw new CustomException("Custom exception triggered");
	}

	public static void importFile() throws CustomException {
		FileReader reader = null;
		try {
			reader = new FileReader("D:\\Temp\\test.txt");
			System.out.println("File Read Success!!!");
		}
		catch (FileNotFoundException fe)
		{
			System.out.println("File not found: " +  fe.getMessage());
			fe.printStackTrace();
			throw new CustomException(fe.getMessage(), fe);
		}
		catch (Exception e)
		{
			System.out.println("Exception: " +  e.getMessage());
			e.printStackTrace();
		}
		finally {
			System.out.println("Finally invoked");
//			reader.close();
		}
	}
}
