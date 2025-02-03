package com.examples.empapp.controller;

import java.io.IOException;
import java.util.List;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;
import com.examples.empapp.service.EmployeeServiceImpl;

@WebServlet("/addEmployee.do")
public class AddEmployeeController extends HttpServlet {

		EmployeeService empService = new EmployeeServiceImpl();
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			Integer age= Integer.parseInt(req.getParameter("age"));
			String designation = req.getParameter("designation");
			String department = req.getParameter("department");
			String country = req.getParameter("country");
			
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
			System.out.println("Designation: " + designation);
			System.out.println("Departememt: " + department);
			System.out.println("Country: " + country);
			
			Employee emp = new Employee();
			emp.setName(name);
			emp.setAge(age);
			emp.setDesignation(designation);
			emp.setDepartment(department);
			emp.setCountry(country);
			
			empService.create(emp);
			
			System.out.println("Employee created successfully.");
			
			RequestDispatcher rd = req.getRequestDispatcher("listEmployees.do");
			rd.forward(req, resp);
		}
}
