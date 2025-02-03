package com.examples.empapp.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.dao.EmployeeDaoJdbcImpl;
import com.examples.empapp.model.Employee;

public class EmployeeServiceImpl {

	EmployeeDao employeeDao;

	Comparator<Employee> EMPLOYEE_NAME_ASC_SORT = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getName().compareTo(o2.getName());

		}
	};

	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoJdbcImpl();
	}

	public boolean create(Employee employee) {
		//validate employee details
		return employeeDao.create(employee);		
	}

	public Employee get(int id) {
		return employeeDao.get(id);
	}

	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	public boolean update(Employee employee) {
		return employeeDao.update(employee);
	}

	public boolean delete(int id) {
		return employeeDao.delete(id);
	}

	public boolean validate(Employee emp, String msg, Predicate<Employee> condition,
			Function<String, Boolean> operation) {
		if (!condition.test(emp)) {
			return operation.apply(msg);
		}
		return true;
	}

	// Get Employee count greater than given age
	public long getEmployeeCountAgeGreaterThan(Predicate<Employee> condition) {
		long count = employeeDao.getAll().stream().filter(condition).count();

		return count;
	}

	// Get list of Employee IDs whose age is greater than given age
	public List<Integer> getEmployeeIdsAgeGreaterThan(int age) {
		List<Integer> empIds = employeeDao.getAll()
				.stream()
				.filter(emp -> emp.getAge() > age)
				.map(emp -> emp.getEmpId())
				.collect(Collectors.toList());
		return empIds;
	}

	// Get Department wise Employee count
	public Map<String, Long> getEmployeeCountByDepartment() {

		return employeeDao.getAll()
				.stream()
				.map(Employee::getDepartment) // output -> Department name
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				// Key - Department name
				// Value - Count
	}

	// Get Department wise Employee count ordered by Department name
	public Map<String, Long> getEmployeeCountByDepartmentOdered() {
		return employeeDao.getAll()
				.stream()
				.sorted(Comparator.comparing(Employee::getDepartment))
				.collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.counting()));
	}

	// Get Department wise average Employee age ordered by Department name
	public Map<String, Double> getAvgEmployeeAgeByDept() {
		return employeeDao.getAll()
				.stream()
				.sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors
				.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.averagingInt(Employee::getAge)));
	}

	// Get Departments have more than given Employee count
	public List<String> getDepartmentsHaveEmployeesMoreThan(int criteria) {
		// List<String> deptList = new ArrayList<>();

		return employeeDao.getAll()
				.stream()
				.sorted(Comparator.comparing(Employee::getDepartment))
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
				// .forEach((k,v) -> {if(v > criteria) {deptList.add(k);}});
				// return deptList;

				.entrySet().stream() // Creating one more stream to filter the output
				.filter(entry -> entry.getValue() > criteria).map(Map.Entry::getKey).collect(Collectors.toList());
	}

	// Get Employee names starting with given string
	public List<String> getEmployeeNamesStartsWith(String prefix) {
		return employeeDao.getAll()
				.stream().filter(emp -> emp.getName().startsWith(prefix)).map(emp -> emp.getName())
				.collect(Collectors.toList());
	}

	public void bulkImport() {
		int counter = 0;
		try (Scanner in = new Scanner(new FileReader("./input/employee-input.txt"))) {
			while (in.hasNextLine()) {
				String emp = in.nextLine();
				Employee employee = new Employee();
				StringTokenizer tokenizer = new StringTokenizer(emp, ",");

				// Emp ID - Auto Generated
//				employee.setEmpId(Integer.parseInt(tokenizer.nextToken()));
				// Name
				employee.setName(tokenizer.nextToken());
				// Age
				employee.setAge(Integer.parseInt(tokenizer.nextToken()));
				// Designation
				employee.setDesignation(tokenizer.nextToken());
				// Department
				employee.setDepartment(tokenizer.nextToken());
				// Country
				employee.setCountry(tokenizer.nextToken());

				employeeDao.create(employee);
				counter++;
			}
			System.out.format("%d Employees are imported successfully.", counter);
		} catch (IOException e) {
			System.out.println("Error occured while importing employee data. " + e.getMessage());
		}
	}

	public void bulkExport() {
		try (FileWriter out = new FileWriter("./output/employee-output.txt")) {
			employeeDao
					.getAll()
					.stream()
					.map(emp -> emp.getEmpId() + "," + emp.getName() + "," + emp.getAge() + ","
							+ emp.getDesignation() + "," + emp.getDepartment() + "," + emp.getCountry() + "\n")
					.forEach(rec -> {
						try {
							out.write(rec);
						} catch (IOException e) {
							System.out
									.println("Error occured while writing employee data into file. " + e.getMessage());
							e.printStackTrace();
						}
					});
			System.out.format("%d Employees are exported successfully.", employeeDao.getAll().size());			
		} catch (IOException e) {
			System.out.println("Error occured while exporting employee data. " + e.getMessage());
		}		
	}
}
