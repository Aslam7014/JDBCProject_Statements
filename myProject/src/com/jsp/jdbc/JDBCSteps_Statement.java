package com.jsp.jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class JDBCSteps_Statement {
	public static void main(String[] args) {
		
		try {
			// 1. Load & Register the Driver------------------------------------------
		//Driver driver = new com.mysql.cj.jdbc.Driver();
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2.Establish the connection--------------------------------------------------
	//	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		
			FileReader fr = new FileReader("Connection.properties");
			Properties p = new Properties();
			p.load(fr);
			String dburl = p.getProperty("url");
			Connection conn = DriverManager.getConnection(dburl, p);
			
	
		// 3.Create Statement----------------------------------------------------------
				Statement st = conn.createStatement();
			
			
		// 4.Execute the query---------------------------------------------------------
		int rowsIserted = st.executeUpdate("INSERT INTO students VALUES(101,'ylam','yy@gmaiil.com',29),(102,'Saruk','sss@gmaiil.com',18)");
		
		// 5.Processing the Result------------------------------------------------------
		if(rowsIserted > 0) {
			System.out.println(rowsIserted + " data inserted n Database");
		}
		else {
			System.out.println("somethng went wrong.... .");
		}
		
		// 6.Close the Connection---------------------------------------------------------
		conn.close();
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
