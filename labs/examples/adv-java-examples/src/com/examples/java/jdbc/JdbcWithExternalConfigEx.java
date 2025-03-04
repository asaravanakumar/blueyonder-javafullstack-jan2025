package com.examples.java.jdbc;

//import com.mysql.cj.jdbc.MysqlDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcWithExternalConfigEx {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// STEP 2: Create Datasource instance
//			MysqlDataSource dataSource = new MysqlDataSource();
			PGSimpleDataSource dataSource = new PGSimpleDataSource();

			// Loading configuration from properties file
			Properties prop = new Properties();
			prop.load(new FileInputStream("jdbc.properties"));

			String dbHost = prop.getProperty("dbHost");
			String dbName = prop.getProperty("dbName");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");

			dataSource.setServerName(dbHost);
//			dataSource.setServerNames(new String[]{dbHost});
			dataSource.setDatabaseName(dbName);
			dataSource.setUser(username);
			dataSource.setPassword(password);


			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = dataSource.getConnection();
			conn.setAutoCommit(false); // enable transaction

			System.out.println("Connection estabilished: " + conn);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			// Insertion with Statement
//			String insertQuery = "INSERT INTO employee (name, age, designation, department, country) VALUES ('Anil', 30, 'Developer', 'Admin', 'India')";
//			//boolean status = stmt.execute(insertQuery);
//			int insertCount = stmt.executeUpdate(insertQuery);
//			System.out.println("Employee inserted " + insertCount);

			// Insertion with Prepared Statement
			String insertQueryForPrepareStmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
			pstmt.setString(1, "Mathew");
			pstmt.setInt(2, 30);
			pstmt.setString(3, "Lead");
			pstmt.setString(4, "IT");
			pstmt.setString(5, "India");
			int insertCount = pstmt.executeUpdate();
			pstmt.close();
			System.out.println(insertCount + " Employee(s) inserted");

			// Updation with Prepared Statement
			String updateQuery = "UPDATE employee SET designation = ? WHERE id = ?";
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, "Software Engineer");
			pstmt.setInt(2, 1);
			int updateCount = pstmt.executeUpdate();
			pstmt.close();
			System.out.println(updateCount + " Employee(s) updated");

			// Deletion with Prepared Statement
			String deleteQuery = "DELETE FROM employee WHERE id = ?";
			pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, 2);
			int deleteCount = pstmt.executeUpdate();
			pstmt.close();
			System.out.println(deleteCount + " Employee(s) updated");

			// persist the changes
			conn.commit();

			String selectQuery = "SELECT * FROM employee";
			rs = stmt.executeQuery(selectQuery);

			// STEP 5: Extract data from result set
			// Header
			System.out.format("\t%s \t%s \t%s \t%s \t%s \t%s\n", "Id", "Age", "Name", "Designation", "Department",
					"Country");
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");

				// Display values
				System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s\n", id, age, name, designation, department, country);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
			}
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException sqle) {
			}
		} finally {
			// finally block used to close resources
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se2) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main
}// end FirstExample