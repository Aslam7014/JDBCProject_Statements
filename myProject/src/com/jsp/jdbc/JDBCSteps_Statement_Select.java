package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCSteps_Statement_Select {
	public static void main(String[] args) {
		
		try {
			// 1. Load & Register the Driver------------------------------------------
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			// 2.Establish the connection--------------------------------------------------
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_studentdb?user=root&password=root");
			
			// 3.Create Statement----------------------------------------------------------
			Statement st = conn.createStatement();
			
			// 4.Execute the query---------------------------------------------------------
			ResultSet rs = st.executeQuery("SELECT * from students");
			
			// 5.Processing the Result------------------------------------------------------
			System.out.println("StudentId\tStudentName\tStudentEmail\tStudentMarks");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t\t");
				System.out.print(rs.getString(2)+"\t\t");
				System.out.print(rs.getString(3)+"\t\t");
				System.out.print(rs.getInt(4)+"\t");
				System.out.println();
			}
			
			// 6.Close the Connection---------------------------------------------------------
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
