package com.examples.java.java8.lambda;

/**
 * Models Employee object
 */
public class Employee {

	// access modifiers
	// private, public, protected, default

	// properties
	private int empId;
	private String name;
	private int age;
	private String gender;
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
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.gender = gender;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
