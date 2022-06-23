package com.revature.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://default.c4f146kcs3yu.us-east-1.rds.amazonaws.com:5432/postgres";
		String username = "";
		String password = ""; 
		
		try {
			
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			System.out.println(databaseConnection.getMetaData().getDriverName());
			System.out.println("A connection was established");
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}
