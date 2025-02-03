package com.examples.empapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.examples.empapp.model.Employee;
//import com.mysql.cj.jdbc.MysqlDataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class EmployeeDaoJdbcImpl implements EmployeeDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public EmployeeDaoJdbcImpl() {

	}

	// Lazy Initialization
	public Connection getConnection() {
		try {
			if(conn == null) {
		//		MysqlDataSource datasource = new MysqlDataSource();
		//		datasource.setServerName("localhost");
		//		datasource.setDatabaseName("jdbctraining");
		//		datasource.setUser("training");
		//		datasource.setPassword("training");

				PGSimpleDataSource datasource = new PGSimpleDataSource();
				datasource.setServerNames(new String[]{"localhost"});
				datasource.setDatabaseName("fsd_training");
				datasource.setUser("postgres");
				datasource.setPassword("postgres");

				conn = datasource.getConnection();
				System.out.println("Connection created successfully. " + conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public boolean create(Employee employee) {
		// INSERT employee data
		boolean status = false;
		try {
//			stmt = conn.createStatement();
//			String query = "INSERT INTO employee(name, age, designation, department, country) values(\""
//					+ employee.getName() + "\"," + employee.getAge() + ",\"" + employee.getDesignation() + "\",\""
//					+ employee.getDepartment() + "\",\"" + employee.getCountry() + "\")";

			String query = "INSERT INTO employee(name, age, designation, department, country) values(?,?,?,?,?)";
			pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, employee.getName());
			pstmt.setInt(2, employee.getAge());
			pstmt.setString(3, employee.getDesignation());
			pstmt.setString(4, employee.getDepartment());
			pstmt.setString(5, employee.getCountry());

//			status = pstmt.execute(query);
//			pstmt.execute();
			status = pstmt.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean update(Employee employee) {
		// UPDATE employee data
		boolean status = false;
		try {
//			stmt = conn.createStatement();

//			String query = "UPDATE employee SET name = \"" + employee.getName() + "\", age = " + employee.getAge()
//					+ ",designation = \"" + employee.getDesignation() + "\",department = \"" + employee.getDepartment()
//					+ "\", country = \"" + employee.getCountry() + "\" WHERE id = " + employee.getEmpId();

			String query = "UPDATE employee SET name=?, age=?, designation=?, department=?, country=? WHERE id = ?";
			pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, employee.getName());
			pstmt.setInt(2, employee.getAge());
			pstmt.setString(3, employee.getDesignation());
			pstmt.setString(4, employee.getDepartment());
			pstmt.setString(5, employee.getCountry());
			pstmt.setInt(6, employee.getEmpId());

			System.out.println(query);
//			status = pstmt.execute(query);

			status = pstmt.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean delete(int id) {
		// DELETE employee data
		boolean status = false;
		try {
			stmt = getConnection().createStatement();

			String query = "DELETE FROM employee WHERE id = " + id;

			status = stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public Employee get(int empId) {
		// SELECT employee data
		Employee emp = null;
		String query = "SELECT * FROM employee WHERE id = " + empId;
		try {
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");
				emp = new Employee(id, name, age, designation, department, country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public List<Employee> getAll() {
		// SELECT All employees
		List<Employee> employees = new ArrayList<>();
		try {
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery("SELECT * FROM employee");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String designation = rs.getString("designation");				
				String department = rs.getString("department");
				String country = rs.getString("country");
				employees.add(new Employee(id, name, age, designation, department, country));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}
}