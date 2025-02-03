package com.exampes.empapp.service;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;
import com.examples.empapp.service.EmployeeServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
    @InjectMocks
    EmployeeService empService = new EmployeeServiceImpl();

    @Mock
    EmployeeDao empDao;

    // Employee emp = new Employee();
    // Mockito.when(empDao.create(emp)).thenReturn("Created Successfully")
    // Mockito.when(empDao.create(emp)).thenThrow(new EmployeeValidationException()");

//    @Spy
    List<Employee> employees = new ArrayList<>();

    @BeforeEach
    public void initializeEmployees() {
        Employee emp1 = new Employee(100, "Martin",30,"Lead","Sales","India");
        Employee emp2 = new Employee(101, "Amit",30,"Manager","Finance","India");
        employees.add(emp1);
        employees.add(emp2);
    }

    @AfterEach
    public void cleanup() {
        employees.clear();
    }


    @Test
    public void shouldCreateEmployee_whenMandatoryDetailsGiven() {
        Employee emp = new Employee("Martin",30,"Lead","Sales","India");

        Mockito.when(empDao.create(emp)).thenReturn(true);

//        Mockito.when(empDao.getAll()).thenReturn(employees);


        //int empId, String name, int age, String designation, String department, String country
        assertEquals(true, empService.create(emp));
//        assertEquals(3, employees.size());

    }

    @Test
    public void shouldGetAllEmployees_WhenNoArguments() {
        Mockito.when(empDao.getAll()).thenReturn(employees);

        List<Employee> employees = empService.getAll();
        System.out.println(employees.size());
        assertNotNull(employees);
    }
}
