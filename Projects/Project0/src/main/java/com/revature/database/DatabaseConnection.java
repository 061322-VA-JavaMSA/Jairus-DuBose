package com.revature.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.revature.*;

public class DatabaseConnection {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://default.c4f146kcs3yu.us-east-1.rds.amazonaws.com:5432/postgres";
		String username = "";
		String password = ""; 
		
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		Users u = null; 
		
		try {
			
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			System.out.println(databaseConnection.getMetaData().getDriverName());
			System.out.println("A connection was established");
			
			String sql = "select * from users where users.id =" + input + ";";
			Connection databaseConnection1 = DriverManager.getConnection(url,username,password);
			Statement sqlStatement = databaseConnection1.createStatement();
			ResultSet resultOutput = sqlStatement.executeQuery(sql);
			while(resultOutput.next()) {
				u = new Users();
				u.setId(resultOutput.getInt(input));
				u.setUsername(resultOutput.getString("username"));
				u.setPassword(resultOutput.getString("password"));
				u.setUsertype(resultOutput.getString("usertype"));
			}
			
			databaseConnection.close();
			databaseConnection1.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(u);
		
	}
		
}
