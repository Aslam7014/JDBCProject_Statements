package com.jsp.jdbc;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCSteps_Properties {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			FileReader fr = new FileReader("Connection.properties");
			Properties p = new Properties();
			p.load(fr);
			String dburl = p.getProperty("url");
			Connection conn = DriverManager.getConnection(dburl, p);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
