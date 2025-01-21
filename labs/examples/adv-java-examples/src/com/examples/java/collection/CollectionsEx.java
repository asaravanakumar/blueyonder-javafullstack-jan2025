package com.examples.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class CollectionsEx {
	
	public static void main(String[] args)
	{
		List employees = new ArrayList();

		employees.add(new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000));
		employees.add(new Employee(101, "Mukesh", 25, "Male", "Developer", "IT", 20000));
		employees.add(new Employee(102, "Jancy", 30, "Female", "Sr.Developer", "IT", 30000));
		employees.add(new Employee(103, "John", 28, "Male", "Developer", "IT", 40000));
		employees.add(new Employee(104, "Mathew", 30, "Male", "Developer", "IT", 60000));
		employees.add(new Employee(105, "Mary", 27, "Female", "Sr.Developer", "IT", 70000));

		for (Object emp : employees) {
			System.out.println(emp + " " + emp.hashCode());
		}

		// Synchronized List
		List synEmployees = Collections.synchronizedList(employees);

//		for (Object emp : synEmployees) {
//			System.out.println(emp + " " + emp.hashCode());
//		}

//		List readOnlyEmployees = Collections.unmodifiableList(employees);
//
//		// throws UnsupportedOperationException
//		readOnlyEmployees.add(new Employee());
		
		// Employees are sorted by age
		Comparator EMPLOYEE_SORT_BY_NAME = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Employee && o2 instanceof Employee) {
					return ((Employee) o2).getName().compareTo(((Employee) o1).getName());
				}
				return 0;
			}
		};		
		
		Collections.sort(employees, EMPLOYEE_SORT_BY_NAME);

		System.out.println("\nSorted output:");
		for (Object emp : employees) {
			System.out.println(emp + " " + emp.hashCode());
		}

		System.out.println(Collections.max(employees));
		
	}

}
