package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://default.c4f146kcs3yu.us-east-1.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "elephant";
		
		try {
			Connection c = DriverManager.getConnection(url,username,password);
			System.out.println(c.getMetaData().getDriverName());
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner scan = new Scanner(System.in);
		int id = Integer.parseInt(scan.nextLine());
		User u = null; 
		try {
			String sql = "select * from users where id = " + id + ";";
			Connection c = DriverManager.getConnection(url,username,password);
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt(id));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
			//left of at 7:19
			//c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u);
		scan.close();
		
		
		
	}

}
