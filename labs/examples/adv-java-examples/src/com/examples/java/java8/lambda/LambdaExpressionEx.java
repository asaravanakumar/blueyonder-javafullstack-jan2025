package com.examples.java.java8.lambda;

import java.util.function.Consumer;

public class LambdaExpressionEx {

	   public static void main(String args[]) {
		   LambdaExpressionEx lamExp = new LambdaExpressionEx();
			
	      //with type declaration
	      MathOperation addition = (int a, int b) -> a + b;
			
	      //with out type declaration
	      MathOperation subtraction = (a, b) -> a - b;
			
	      //with return statement along with curly braces
	      MathOperation multiplication = (int a, int b) -> { return a * b; };
			
	      //without return statement and without curly braces
	      MathOperation division = (int a, int b) -> a / b;
			
	      System.out.println("10 + 5 = " + lamExp.operate(10, 5, addition));
	      System.out.println("10 - 5 = " + lamExp.operate(10, 5, subtraction));
	      System.out.println("10 x 5 = " + lamExp.operate(10, 5, multiplication));
	      System.out.println("10 / 5 = " + lamExp.operate(10, 5, division));
	      
	  
	      //with parenthesis and using custom functional interface
	      GreetingService greetService2 = (message) ->
	      System.out.println("Hello " + message);
	      greetService2.sayMessage("Suresh");

		   //without parenthesis and using Consumer functional interface
		   Consumer<String> greetService1 = message ->
				   System.out.println("Hello " + message);
		   greetService1.accept("Mahesh");
	   }
		
	   interface MathOperation {
	      int operation(int a, int b);
	   }
		
	   
	   interface GreetingService {
	      void sayMessage(String message);
	   }
		
	   
	   private int operate(int a, int b, MathOperation mathOperation) {
	      return mathOperation.operation(a, b);
	   }

	}