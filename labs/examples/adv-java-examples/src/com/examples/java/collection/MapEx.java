package com.examples.java.collection;

import java.util.*;

public class MapEx {

	public static void main(String[] args) {

		// Employees are sorted by name
		Comparator<Employee> EMPLOYEE_SORT_BY_NAME = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				// if (o1 instanceof Employee && o2 instanceof Employee) {
				// return ((Employee) o1).getName().compareTo(((Employee) o2).getName());
				// }
				// can directly compare the employee objects with generic declaration
				return o1.getName().compareTo(o2.getName());
			}
		};

		Map<Integer, Employee> employees = new TreeMap<>();

		employees.put(100, new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000.0));
		employees.put(101, new Employee(101, "Mukesh", 25, "Male", "Developer", "IT", 20000.0));
		employees.put(102, new Employee(102, "Jancy", 30, "Female", "Sr.Developer", "IT", 30000.0));
		employees.put(103, new Employee(103, "John", 28, "Male", "Developer", "IT", 40000.0));
		employees.put(104, new Employee(104, "Mathew", 30, "Male", "Developer", "IT", 60000.0));
		employees.put(105, new Employee(105, "Mary", 27, "Female", "Sr.Developer", "IT", 70000.0));

		List<Employee> employeesSorted = new ArrayList<>(employees.values());

		Collections.sort(employeesSorted, EMPLOYEE_SORT_BY_NAME);

		for (Employee emp : employeesSorted) {
			System.out.println(emp);
		}
	}

}
