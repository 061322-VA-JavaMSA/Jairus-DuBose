package com.revature.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.revature.Users;
import com.revature.Weapons;
import com.revature.Potions;
import com.revature.Armours;

public class DatabaseConnection {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://default.c4f146kcs3yu.us-east-1.rds.amazonaws.com:5432/postgres";
		String username = "";
		String password = ""; 
		
		/*
		 * Scanner scan = new Scanner(System.in); int input =
		 * Integer.parseInt(scan.nextLine());
		 */
		Users userInfo;
		Users userInfo2; 
		Weapons weaponInfo;
		Armours armourInfo;
		Potions potionInfo;
		
		try {
			
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			//System.out.println(databaseConnection.getMetaData().getDriverName());
			System.out.println("A connection was established");
			
			System.out.println("Please Enter The ID You Want To Look Up");
			Scanner scan = new Scanner(System.in);
			int Userinput = Integer.parseInt(scan.nextLine());
			
			String sql = "select * from users where users.id =" + Userinput + ";";
			//establishes connection
			//Connection databaseConnection1 = DriverManager.getConnection(url,username,password);
			//Sets/Creates the sql statement
			Statement sqlStatement = databaseConnection.createStatement();
			//Executes the sql query 
			ResultSet resultOutput = sqlStatement.executeQuery(sql);
			
			while(resultOutput.next()) {
				userInfo = new Users();
				userInfo.setId(resultOutput.getInt("id"));
				userInfo.setUsername(resultOutput.getString("username"));
				userInfo.setPassword(resultOutput.getString("password"));
				userInfo.setUsertype(resultOutput.getString("usertype"));
				
				
				
				System.out.println(userInfo);
			}
			
			System.out.println("Please Enter The Username You Want To Look Up");
			Scanner usernameScan = new Scanner(System.in);
			String Userinput2 = usernameScan.nextLine();
			
			String usernamesql = "select * from users where users.username = '"+ Userinput2+"';";
			//establishes connection
			//Connection databaseConnection1 = DriverManager.getConnection(url,username,password);
			//Sets/Creates the sql statement
			Statement usernamesqlStatement = databaseConnection.createStatement();
			//Executes the sql query 
			ResultSet usernameResultOutput = usernamesqlStatement.executeQuery(usernamesql);
			
			while(usernameResultOutput.next()) {
				userInfo2 = new Users();
				userInfo2.setId(usernameResultOutput.getInt("id"));
				userInfo2.setUsername(usernameResultOutput.getString("username"));
				userInfo2.setPassword(usernameResultOutput.getString("password"));
				userInfo2.setUsertype(usernameResultOutput.getString("usertype"));
				
				
				
				System.out.println(userInfo2);
			}
			
			System.out.println("Please Enter The Weapon You Want To Look Up");
			Scanner weaponScan = new Scanner(System.in);
			String weaponInput = (weaponScan.nextLine());
			String weaponsql = "select * from weapons where weapons.weapon_name = '" + weaponInput + "';";
			Statement weaponsqlStatement = databaseConnection.createStatement();
			//Executes the sql query 
			ResultSet weaponresultOutput = sqlStatement.executeQuery(weaponsql);
			
			while(weaponresultOutput.next()) {
				weaponInfo = new Weapons();
				weaponInfo.setId(weaponresultOutput.getInt("id"));
				weaponInfo.setWeapon_name(weaponresultOutput.getString("weapon_name")); 
				weaponInfo.setWeapon_price(weaponresultOutput.getInt("weapon_price"));
				weaponInfo.setWeapon_quantity(weaponresultOutput.getInt("weapon_quantity"));
				
				
				
				System.out.println(weaponInfo);
			}
			
			System.out.println("Please Enter The Amour You Want To Look Up");
			Scanner armourScan = new Scanner(System.in);
			String armourInput = (armourScan.nextLine());
			String armoursql = "select * from armours where armours.armour_name = '" + armourInput + "';";
			Statement armoursqlStatement = databaseConnection.createStatement();
			//Executes the sql query 
			ResultSet armourResultOutput = sqlStatement.executeQuery(armoursql);
			
			while(armourResultOutput.next()) {
				armourInfo = new Armours();
				armourInfo.setId(armourResultOutput.getInt("id"));
				armourInfo.setArmour_name(armourResultOutput.getString("armour_name")); 
				armourInfo.setArmour_price(armourResultOutput.getInt("armour_price"));
				armourInfo.setArmour_quantity(armourResultOutput.getInt("armour_quantity"));
				
				
				
				System.out.println(armourInfo);
			}
			
			System.out.println("Please Enter The Potion You Want To Look Up");
			Scanner potionScan = new Scanner(System.in);
			String potionInput = (potionScan.nextLine());
			String potionsql = "select * from potions where potions.potion_name = '" + potionInput + "';";
			Statement potionsqlStatement = databaseConnection.createStatement();
			//Executes the sql query 
			ResultSet potionResultOutput = sqlStatement.executeQuery(potionsql);
			
			while(potionResultOutput.next()) {
				potionInfo = new Potions();
				potionInfo.setId(potionResultOutput.getInt("id"));
				potionInfo.setPotion_name(potionResultOutput.getString("potion_name")); 
				potionInfo.setPotion_price(potionResultOutput.getInt("potion_price"));
				potionInfo.setPotion_quantity(potionResultOutput.getInt("potion_quantity"));
				
				
				
				System.out.println(potionInfo);
			}
			
			
			databaseConnection.close();
			//databaseConnection1.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}
