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

	static Users userInfo;
	static Users userInfo2; 
	static Weapons weaponInfo;
	static Armours armourInfo;
	static Potions potionInfo;
	
	static String url = "jdbc:postgresql://default.c4f146kcs3yu.us-east-1.rds.amazonaws.com:5432/postgres";
	static String username = "";
	static String password = ""; 
	
	public static void testMethod() {
		
		
		try {
			
			Connection databaseConnection = DriverManager.getConnection(url, username, password);

			System.out.println("A connection was established");
			
			
			databaseConnection.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was an error connecting to the database");
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void RetrieveUserInfo() {
		try {
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			System.out.println("Please Enter The Username You Want To Look Up");
			Scanner usernameScan = new Scanner(System.in);
			String Userinput2 = usernameScan.nextLine();
			
			String usernamesql = "select * from users where users.username = '"+ Userinput2+"';";
			
			Statement usernamesqlStatement = databaseConnection.createStatement();
 
			ResultSet usernameResultOutput = usernamesqlStatement.executeQuery(usernamesql);
			
			while(usernameResultOutput.next()) {
				userInfo2 = new Users();
				userInfo2.setId(usernameResultOutput.getInt("id"));
				userInfo2.setUsername(usernameResultOutput.getString("username"));
				userInfo2.setPassword(usernameResultOutput.getString("password"));
				userInfo2.setUsertype(usernameResultOutput.getString("usertype"));
				
				
				
				System.out.println(userInfo2);
			}
			
			databaseConnection.close();
			
		}catch(SQLException e) {
			System.out.println("There was an error connecting to User Info");
			e.printStackTrace();
		}
		
	}
	
	public static void RetrieveWeaponInfo() {
		
		try{
			
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			System.out.println("Please Enter The Weapon You Want To Look Up");
			Scanner weaponScan = new Scanner(System.in);
			String weaponInput = (weaponScan.nextLine());
			String weaponsql = "select * from weapons where weapons.weapon_name = '" + weaponInput + "';";
			Statement weaponsqlStatement = databaseConnection.createStatement();
			ResultSet weaponresultOutput = weaponsqlStatement.executeQuery(weaponsql);
			
			while(weaponresultOutput.next()) {
				weaponInfo = new Weapons();
				weaponInfo.setId(weaponresultOutput.getInt("id"));
				weaponInfo.setWeapon_name(weaponresultOutput.getString("weapon_name")); 
				weaponInfo.setWeapon_price(weaponresultOutput.getInt("weapon_price"));
				weaponInfo.setWeapon_quantity(weaponresultOutput.getInt("weapon_quantity"));
				
				
				
				System.out.println(weaponInfo);
			}
			
			databaseConnection.close();
			
		}catch(SQLException e) {
			System.out.println("There was an error connecting to Weapon Info");
			e.printStackTrace();
		}
	
	}
	
	public static void RetrieveArmourInfo() {
		
		try {
			
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			System.out.println("Please Enter The Amour You Want To Look Up");
			Scanner armourScan = new Scanner(System.in);
			String armourInput = (armourScan.nextLine());
			String armoursql = "select * from armours where armours.armour_name = '" + armourInput + "';";
			Statement armoursqlStatement = databaseConnection.createStatement();
			
			ResultSet armourResultOutput = armoursqlStatement.executeQuery(armoursql);
			
			while(armourResultOutput.next()) {
				armourInfo = new Armours();
				armourInfo.setId(armourResultOutput.getInt("id"));
				armourInfo.setArmour_name(armourResultOutput.getString("armour_name")); 
				armourInfo.setArmour_price(armourResultOutput.getInt("armour_price"));
				armourInfo.setArmour_quantity(armourResultOutput.getInt("armour_quantity"));
				
				
				
				System.out.println(armourInfo);
			}
			
			databaseConnection.close();
			
		}catch(SQLException e) {
			
			System.out.println("There was an error connecting to Armour Info");
			e.printStackTrace();
		}
		
	}
	
	public static void RetrievePotionInfo() {
		
		try {
			
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			System.out.println("Please Enter The Potion You Want To Look Up");
			Scanner potionScan = new Scanner(System.in);
			String potionInput = (potionScan.nextLine());
			String potionsql = "select * from potions where potions.potion_name = '" + potionInput + "';";
			Statement potionsqlStatement = databaseConnection.createStatement();
			
			ResultSet potionResultOutput = potionsqlStatement.executeQuery(potionsql);
			
			while(potionResultOutput.next()) {
				potionInfo = new Potions();
				potionInfo.setId(potionResultOutput.getInt("id"));
				potionInfo.setPotion_name(potionResultOutput.getString("potion_name")); 
				potionInfo.setPotion_price(potionResultOutput.getInt("potion_price"));
				potionInfo.setPotion_quantity(potionResultOutput.getInt("potion_quantity"));
				
				
				
				System.out.println(potionInfo);
			}
			
			databaseConnection.close();
			
		}catch(SQLException e) {
			System.out.println("There was an error connecting to Potion Info");
			e.printStackTrace();
		}
		
	}
	
	public static void UpdateStore(String ItemCategory,String ItemName, int ItemAmount) {
		
		try {
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			//The manager or employees types in Weapons
			if (ItemCategory.equals("Weapons")) {
				//This is the Sql statement ItemAmount should be 15 and the ItemName would be something like Greatsword
				String updateSql = "update weapons set weapon_quantity = "+ ItemAmount +" where weapon_name = '" + ItemName + "';";
				Statement updateSqlStatement = databaseConnection.createStatement();
				
				//Sql statement to ensure the quanitity changed
				String checkUpdateSql = "select * from weapons where weapons.weapon_name = '" + ItemName + "';";
				
				ResultSet updateResultOutput = updateSqlStatement.executeQuery(checkUpdateSql);
				
				while(updateResultOutput.next()) {
					weaponInfo = new Weapons();
					weaponInfo.setId(updateResultOutput.getInt("id"));
					weaponInfo.setWeapon_name(updateResultOutput.getString("weapon_name")); 
					weaponInfo.setWeapon_price(updateResultOutput.getInt("weapon_price"));
					weaponInfo.setWeapon_quantity(updateResultOutput.getInt("weapon_quantity"));
					
					System.out.println(weaponInfo);
				}	
				
			}
			
			else if (ItemCategory.equals("Armours")) {
				
				String updateSql = "update armours set armour_quantity = "+ ItemAmount +" where armour_name = '" + ItemName + "';";
				Statement updateSqlStatement = databaseConnection.createStatement();
				
				String checkUpdateSql = "select * from armours where armours.armour_name = '" + ItemName + "';";
				
				ResultSet updateResultOutput = updateSqlStatement.executeQuery(checkUpdateSql);
				
				while(updateResultOutput.next()) {
					armourInfo = new Armours();
					armourInfo.setId(updateResultOutput.getInt("id"));
					armourInfo.setArmour_name(updateResultOutput.getString("armour_name")); 
					armourInfo.setArmour_price(updateResultOutput.getInt("armour_price"));
					armourInfo.setArmour_quantity(updateResultOutput.getInt("armour_quantity"));
					
					System.out.println(armourInfo);
				}
				
			}
			
			else if (ItemCategory.equals("Potions")) {
				
				String updateSql = "update potions set potion_quantity = "+ ItemAmount +" where potion_name = '" + ItemName + "';";
				Statement updateSqlStatement = databaseConnection.createStatement();
				
				String checkUpdateSql = "select * from potions where potions.potion_name = '" + ItemName + "';";
				
				ResultSet updateResultOutput = updateSqlStatement.executeQuery(checkUpdateSql);
				
				while(updateResultOutput.next()) {
					potionInfo = new Potions();
					potionInfo.setId(updateResultOutput.getInt("id"));
					potionInfo.setPotion_name(updateResultOutput.getString("potion_name")); 
					potionInfo.setPotion_price(updateResultOutput.getInt("potion_price"));
					potionInfo.setPotion_quantity(updateResultOutput.getInt("potion_quantity"));
					
					System.out.println(potionInfo);
				}	
				
			}
			
			else {
				
				System.out.println("There was an error entering the category name");
				
			}
			
			databaseConnection.close();

			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was am error connecting to Update Store");
			e.printStackTrace();
		}
		
	}
	
	public static void MakeOffer() {
		
		try {
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			System.out.println("What are you looking for/nWeappns, Armours, Potions");
			Scanner userInput = new Scanner(System.in);
			String userSelection = userInput.next();
			
			if (userSelection.equals("Weapons")) {
				
				String weaponSQL = "select * from weapons;";
				
				Statement weaponSqlStatement = databaseConnection.createStatement();
				
				ResultSet updateResultOutput = weaponSqlStatement.executeQuery(weaponSQL);
				
				while(updateResultOutput.next()) {
					weaponInfo = new Weapons();
					weaponInfo.setId(updateResultOutput.getInt("id"));
					weaponInfo.setWeapon_name(updateResultOutput.getString("weapon_name")); 
					weaponInfo.setWeapon_price(updateResultOutput.getInt("weapon_price"));
					weaponInfo.setWeapon_quantity(updateResultOutput.getInt("weapon_quantity"));
					
					System.out.println(weaponInfo);
				}
				
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
