package com.examples.java.collection;

import java.util.HashSet;

public class HashSetEx {

	public static void main(String[] args) {

//		Set skills = new HashSet();
//		skills.add("Java");
//		skills.add("Python");
//		skills.add(".Net");
//		skills.add("Java");
//		skills.add(null);
//
//		System.out.println(skills);
//
//		Iterator it = skills.iterator();
//
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}

		HashSet employees = new HashSet();


		employees.add(new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000));
		employees.add(new Employee(101, "Mukesh", 25, "Male", "Developer", "IT", 20000));
		employees.add(new Employee(102, "Jancy", 30, "Female", "Sr.Developer", "IT", 30000));
		employees.add(new Employee(103, "John", 28, "Male", "Developer", "IT", 40000));
		employees.add(new Employee(104, "Mathew", 30, "Male", "Developer", "IT", 60000));
		employees.add(new Employee(105, "Mary", 27, "Female", "Sr.Developer", "IT", 70000));
		employees.add(new Employee(102, "Mary", 27, "Female", "Sr.Developer", "IT", 70000));

		for (Object emp : employees) {
			System.out.println(emp + " " + emp.hashCode());
		}

//		System.out.println(employees);

		Employee emp1 = new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000);
//		Employee emp2 = new Employee(105, "Mukesh", 25, "Male", "Developer", "IT", 20000);
//
//		// compares Employee objects based on empId
//		System.out.println(emp1.equals(emp2));

		employees.remove(emp1);

		System.out.println(employees);
	}
}
