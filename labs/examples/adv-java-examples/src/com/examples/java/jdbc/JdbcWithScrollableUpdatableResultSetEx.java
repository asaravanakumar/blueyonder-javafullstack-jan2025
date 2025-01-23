package com.examples.java.jdbc;

//STEP 1. Import required packages

import java.sql.*;

public class JdbcWithScrollableUpdatableResultSetEx {
	// JDBC driver name and database URL
//	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String JDBC_DRIVER = "org.postgresql.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/training";

	// Database credentials
//	static final String USER = "training";
//	static final String PASS = "training";
	static final String USER = "postgres";
	static final String PASS = "postgres";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// STEP 2: Register JDBC driver with Driver Manager
			Class.forName(JDBC_DRIVER);
			System.out.println("Postgres driver registered...");
			
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(true); // enable transaction

			System.out.println("Connection estabilished: " + conn);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.CLOSE_CURSORS_AT_COMMIT);
			
			String selectQuery = "SELECT * FROM employee";
			rs = stmt.executeQuery(selectQuery);
			
			// STEP 5: Extract data from result set
			ResultSetMetaData rsmeta = rs.getMetaData();
			
			int cols = rsmeta.getColumnCount();

			// Header
			for(int i=1; i <= cols; i++) {
				System.out.print("\t" + rsmeta.getColumnName(i));
			}
			System.out.println();
			
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
			
			// INSERT
			rs.moveToInsertRow(); // moves cursor to the insert row
			rs.updateString(2, "John"); // name
			rs.updateInt(3,35);	// age
			rs.updateString(4, "Manager");	// designation
			rs.updateString(5, "Quality");	// department
			rs.updateString(6, "India"); // country
			rs.insertRow(); // inserts row into resultset object and underlying db
			rs.beforeFirst();	// moves cursor to the head position
			 
			// UPDATE
			rs.absolute(2);
			rs.updateString(2, "Kumar");
			rs.updateRow();
			 
			 // DELETE
			 rs.relative(1);
			 rs.deleteRow();
			 
//			rs.moveToCurrentRow(); // moves cursor to the current position
			
//			System.out.println(rs.getRow());	// prints current cursor position

//			rs.relative(10);	// cursor moves n rows relative from current position
//			System.out.println(rs.getRow());	// prints current cursor position
			
//			rs.absolute(2);		// cursor moves to given position
				
			System.out.println("After...");
			rs.beforeFirst();
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
			} catch (SQLException e) {}
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException sqle) {}			
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