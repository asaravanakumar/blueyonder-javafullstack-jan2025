package com.examples.java.oops;

public class EmployeeMain {

	public static void main(String[] args) {
		// Creates Employee object of type Employee
		System.out.println("Employee object of type Employee \n");
		Employee employee = new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000.0);
		employee.printDetails();
		employee.appraise();


		// Creates Contractor Object of type Contractor
		System.out.println("Contractor object of type Contractor");
		Contractor contractor = new Contractor(200, "Kumar", 25, "Male", 6, 50000);
		contractor.printDetails();

		// Create Employee object of type Person
//		System.out.println("Employee object of type Person");
//		Person person1 = new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000);
//		person1.printDetails(true); // Employee's printDetails be called
//		person1.sayHello();    // Person's sayHello method be called. Employee's sayHello method be hidden as it is static
//		Person.sayHello();
//		Employee.sayHello();   // Employee's sayHello method be called
//		person1.appraise(); // Not allowed as Person not aware of appraise method

//		// Create Contractor object of type Person
//		System.out.println("Contractor object of type Person");
//		Person person2 = new Contractor(200, "Kumar", 25, "Male", 6, 50000);
//		person2.printDetails(); // Contractor's printDetails be called
//
//		// Create Employee object of type Appriasable
//		System.out.println("Employee object of type Appraisable");
//		Appraisable appraisable = new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000);
////		 appraisable.printDetails(); // Not allowed as Appraisable not aware of
//		// printDetails method
//		appraisable.appraise(); // Employee's appraise method be called
	}
}
