package com.examples.java.java8.stream;

import com.examples.java.java8.lambda.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class ReduceCollectEx {
	
	public static void main(String args[])
	{
		Map<Integer, Employee> employees = new HashMap<>();
		employees.put(100, new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000.0));
		employees.put(101, new Employee(101, "Mary", 45, "Female", "Manager", "Admin", 75000.0));
		employees.put(102, new Employee(102, "John", 25, "Male", "Lead", "Admin", 25000.0));
		employees.put(103, new Employee(103, "Joe", 30, "Female", "Developer", "Admin", 35000.0));
		
		// fetch list of employee ids
		List<Integer> empIds = employees.values()
								.stream()
								.map(Employee::getEmpId)
								.collect(Collectors.toList());
		// print empIds
		empIds.forEach(System.out::println);
		
		
		// print emp ids whose age is more more 30 yrs
		employees.values()
			.stream()
			//.map(Employee::getEmpId)
			.filter(emp -> emp.getAge() > 30)
			.map(Employee::getEmpId)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
	
		//Approach #1: Find Total and Avg Salary
		DoubleSummaryStatistics stats = employees.values()
											.stream()
											.map(Employee::getSalary)
											.collect(Collectors.toList())
											.stream()
											.mapToDouble((sal) -> sal)
											.summaryStatistics();
		
		System.out.println("Total Salary: " + stats.getSum());
		System.out.println("Avg Salary: " + stats.getAverage());
		
		
		//Approach #2: Find Total Salary
		double totalSalary = employees.values()
					//.stream()
				    .parallelStream()
					.map(Employee::getSalary) // stream of salary
					.reduce(0.0, (a,b) -> a.doubleValue() + b.doubleValue()).doubleValue();    // sum of salary
		
		System.out.println("Total Salary: " + totalSalary);
					// 0 + 50000 
					// 50000 + 75000
					// 125000 + 25000
					// 150000 + 35000
					// 185000
					//Identity	=> Initial value or default value
					//Accumulator => Accumulates partial output with current value
		
		//Approach #3: Find Avg Salary - with custom Averager
		Averager averager = employees.values()
							.stream()
							.map(Employee::getSalary) // stream of salary
							.collect(Averager::new, Averager::accept, Averager::combine);
		
					// 185000/4 => 46250
		System.out.println(averager.average());
		
		//Approach #4: Find Avg Salary - with Averaging Collectors
		double avgSalary = employees.values()
				.stream()
				.collect(Collectors.averagingDouble(Employee::getSalary)).doubleValue();		
					// Supplier	=> Factory method to create new instance of container object
					// Accumulator => Accumulates partial output with current value
					// Combiner	=> Combines output of similar container into this container
		System.out.println(avgSalary);
		
		// Find Dept wise Employee count
		Map<String, Long> groupByDept = 
				employees.values()
					.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(groupByDept);
		
		// Find Dept wise Employee count sorted by dept
		Map<String, Long> groupSortByDept = 
				employees.values()
					.stream()
					.sorted(Comparator.comparing(Employee::getDepartment))
					.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
		System.out.println(groupSortByDept);
	}
}
