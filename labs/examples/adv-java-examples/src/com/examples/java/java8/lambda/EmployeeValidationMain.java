package com.examples.java.java8.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Demonstrates usage of Lambda expression with custom/standard functional interfaces
 */
public class EmployeeValidationMain {

	// Validator interface
	// can be qualified as functional interface as it is performing single task
//	@FunctionalInterface
//	public interface ValidateEmployee {
//		public boolean test(Employee emp);
//	}

	// Validate method definition
//	public static boolean validate(Employee emp, ValidateEmployee validator) {
//		return validator.test(emp);
//	}

	public static boolean validate(Employee emp, Predicate<Employee> validator) {
		// emp.getAge() >= 20 && emp.getAge() <= 60 && emp.getSalary() > 0
		return validator.test(emp); // executes lambda expression body
	}
	
	public static void handleError(String errorMessage, Consumer<String> consumer)
	{
		consumer.accept(errorMessage);
	}

	public static void main(String[] args) {
		Employee employee = new Employee(100, "Anand", 0, "Male", "Software Engineer", "Admin", 25000.0);
		
//		// Approach #1: Employee Validation with Anonymous inner class passed as method argument
//		boolean valStatus = validate(employee, new ValidateEmployee() {
//			
//			@Override
//			public boolean test(Employee emp) {
//				return emp.getAge() > 0 && emp.getSalary() > 0 && (emp.getDepartment().equals("Admin") || emp.getDepartment().equals("IT"));
//			}
//		});		

		// Approach #2: Employee Validation with Anonymous inner class assigned to local variable
//		ValidateEmployee validator = new ValidateEmployee() {
//
//			@Override
//			public boolean test(Employee emp) {
//				return emp.getAge() > 0 && emp.getSalary() > 0;
//			}
//		};
//		
//		boolean valStatus = validate(employee, validator);

		// Approach #3: Employee Validation with Lambda Expression assigned to local variable
//		ValidateEmployee validator = (Employee emp) -> {return emp.getAge() >= 20 && emp.getAge() <= 60 && emp.getSalary() > 0;};
//		boolean valStatus = validate(employee, validator);

		
		// Approach #4: Employee Validation with standard Lambda Expression assigned to local variable
//		Predicate<Employee> validator = (Employee emp) -> {return emp.getAge() >= 20 && emp.getAge() <= 60 && emp.getSalary() > 0;};
//		boolean valStatus = validate(employee, validator);
		
		// Approach #5: Employee Validation with Lambda Expression passing as method argument
		boolean valStatus = validate(employee, emp -> emp.getAge() >= 20 && emp.getAge() <= 60 && emp.getSalary() > 0);

		if (valStatus) {
			// Logic to save employee details
			System.out.println("Employee saved");
		}
		else 
		{
			handleError("Invalid Age or Salary", msg -> {System.out.println("Validation Error:" );System.out.println(msg);});
		}

	}

}
