package com.examples.java.oops;

import java.util.Date;

/**
 * Models Employee object
 */
@SuppressWarnings({"checked", "deprecation"})
public class Employee extends Person implements Appraisable {



	// access modifiers
	// private, public, protected, default

	// properties
	private int empId;
	private String designation;
	private String department;
	private double salary;

	// default constructor
	public Employee() {
		// this(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000);
		System.out.println("Employee class default constructor");
	}

	// overloaded custom constructor
	public Employee(int empId, String name, int age, String gender, String designation, String department, double salary) {
		super(name, age, gender);
		this.empId = empId;
		this.designation = designation;
		this.department = department;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	protected void printDetails() {
		// print employee details
		System.out.println("Print employee details");
		System.out.println("EmpId: " + this.getEmpId());
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());
		System.out.println("Designation: " + this.getDesignation());
		System.out.println("Department: " + this.getDepartment());
		System.out.println("Salary: " + this.getSalary());
		System.out.println();
	}

	public static void sayHello() {
		System.out.println("Hello Employee \n");
	}

	@Override
	public void appraise() {
		System.out.println("Employee Appriased \n");
	}

	@Override
	protected void printDetails(boolean dontPrintAge) {
		System.out.println("Employee Print Details without Age..");
	}

	@Override
	public int hashCode() {
		return this.getEmpId() % 5;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			return this.getEmpId() == ((Employee) obj).getEmpId();
		}
		return false;
	}

	public String toString() {
		return String.valueOf(this.empId) + " " + String.valueOf(this.getName() + " " + String.valueOf(this.getAge())) + " " + this.getDepartment() + " " + this.getSalary();
	}

}
