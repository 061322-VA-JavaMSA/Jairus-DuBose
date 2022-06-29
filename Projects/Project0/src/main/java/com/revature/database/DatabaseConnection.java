package com.revature.database;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Users;
import com.revature.Weapons;
import com.revature.Potions;
import com.revature.StoreDriver;
import com.revature.Armours;
import com.revature.MenuDriver;
import java.time.LocalDate;

public class DatabaseConnection {

	static Users userInfo;
	static Users userInfo2; 
	static Weapons weaponInfo;
	static Armours armourInfo;
	static Potions potionInfo;
	
	static Transactions transactionInfo;
	
	private static Logger loginLog = LogManager.getLogger(DatabaseConnection.class);
	
	static String url = "jdbc:postgresql://default.c4f146kcs3yu.us-east-1.rds.amazonaws.com:5432/postgres";
	static String username = "postgres";
	static String password = "elephant"; 
	
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
	
	public static void newUserCreation(String userName, String userPassword, String userType) {
		
		try {
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			String userCreationSql = "insert into users (username, password, usertype) values ('"+userName+"','"+userPassword+"','"+userType+"')";
			Statement userCreationSqlStatement = databaseConnection.createStatement();
			userCreationSqlStatement.execute(userCreationSql);
			System.out.println("User was created");
			System.out.println("Proceeding to Login Menu");
			
			RetrieveUserInfo(); 
			
		}catch(SQLException e) {
			System.out.println("There was an error connecting to New User Creation");
			e.printStackTrace();
		}
		
	}
	
	public static void RetrieveUserInfo() {
		try {
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			System.out.println("Please Enter Your Username");
			Scanner usernameScan = new Scanner(System.in);
			String username = usernameScan.next();
			
			System.out.println("Please Enter Your Password");
			Scanner userPasswordScan = new Scanner(System.in);
			String userpassword = userPasswordScan.next();
			
			String usernamesql = "select * from users where users.username = '"+ username+"'and users.password = '" +userpassword+"';";
			
			Statement usernamesqlStatement = databaseConnection.createStatement();
 
			ResultSet usernameResultOutput = usernamesqlStatement.executeQuery(usernamesql);
			
			while(usernameResultOutput.next()) {
				userInfo2 = new Users();
				userInfo2.setId(usernameResultOutput.getInt("id"));
				userInfo2.setUsername(usernameResultOutput.getString("username"));
				userInfo2.setPassword(usernameResultOutput.getString("password"));
				userInfo2.setUsertype(usernameResultOutput.getString("usertype"));
				
				
				
				System.out.println("Here is your information: "+userInfo2);
				
				//try {
				
				String userType = userInfo2.getUsertype(); 
				if(userType.equals("manager")) {
					
					System.out.println("Proceeding to Manager Menu");
					MenuDriver.ManagerMenu();
					
				}
				else if(userType.equals("employee")) {
					
					System.out.println("Proceeding to Employee Menu");
					MenuDriver.EmployeeMenu();
				}
				else if(userType.equals("customer")) {
					
					System.out.println("Proceeding to Customer Menu");
					MenuDriver.CustomerMenu();
				}
				else {
					
					//throw new UserLoginException();
					
					
					  System.out.println("An Error has occured returning to Main Menu");
					  MenuDriver.welcomeMenu();
					 
					
				}
				
				/*}catch(UserLoginException e) {
					System.out.println("User not found");
					loginLog.error("Login Exception was thrown"+ e.getMessage());
				}*/
			}
			
			databaseConnection.close();
			
		}catch(SQLException e) {
			System.out.println("There was an error connecting to User Info");
			loginLog.error("Login Exception was thrown"+ e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void RetrieveEmployeeInfo(String employeeName) {
		
		try {
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			String employeesql = "select * from users where users.username = '"+ employeeName +"';";
			
			Statement employeesqlStatement = databaseConnection.createStatement();
 
			ResultSet employeeResultOutput = employeesqlStatement.executeQuery(employeesql);
			
			while(employeeResultOutput.next()) {
				userInfo2 = new Users();
				userInfo2.setId(employeeResultOutput.getInt("id"));
				userInfo2.setUsername(employeeResultOutput.getString("username"));
				userInfo2.setPassword(employeeResultOutput.getString("password"));
				userInfo2.setUsertype(employeeResultOutput.getString("usertype"));
			
				String employeeNameOutput = userInfo2.getUsername();
				String employeeTypeOutput = userInfo2.getUsertype();
				System.out.println("Here is your Employee Information: "+employeeNameOutput+" "+employeeTypeOutput);
			}
			
			System.out.println("Press One then enter to return to the Manager Menu");
			Scanner userInput = new Scanner(System.in);
			int returntoManagerMenu = userInput.nextInt();
			
			switch(returntoManagerMenu) {
			case 1:
				System.out.println("Returning to Manager Menu");
				MenuDriver.ManagerMenu();
				break; 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was an error connecting to the Employee Information");
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
				String updateSql = "update weapons set weapon_quantity ="+ ItemAmount +"where weapon_name = '" + ItemName + "';";
				Statement updateSqlStatement = databaseConnection.createStatement();
				updateSqlStatement.executeUpdate(updateSql); 
				
				//Sql statement to ensure the quanitity changed
				String checkUpdateSql = "select * from weapons where weapons.weapon_name = '" + ItemName + "';";
				
				ResultSet updateResultOutput = updateSqlStatement.executeQuery(checkUpdateSql);
				
				while(updateResultOutput.next()) {
					weaponInfo = new Weapons();
					weaponInfo.setId(updateResultOutput.getInt("id"));
					weaponInfo.setWeapon_name(updateResultOutput.getString("weapon_name")); 
					weaponInfo.setWeapon_price(updateResultOutput.getInt("weapon_price"));
					weaponInfo.setWeapon_quantity(updateResultOutput.getInt("weapon_quantity"));
					
					System.out.println("The item was successfully updated: "+weaponInfo);
				}
				
				System.out.println("Please enter your name: ");
				Scanner nameInput = new Scanner(System.in);
				String userInput = nameInput.next();
				
				if(userInput.equals("Jairus")) {
					System.out.println("Returning to Manager Menu");
					MenuDriver.ManagerMenu();
				}
				else {
					System.out.println("Returning to Employee Menu");
					MenuDriver.EmployeeMenu();
				}
				
			}
			
			else if (ItemCategory.equals("Armours")) {
				
				String updateSql = "update armours set armour_quantity = "+ ItemAmount +" where armour_name = '" + ItemName + "';";
				Statement updateSqlStatement = databaseConnection.createStatement();
				updateSqlStatement.execute(updateSql); 
				
				String checkUpdateSql = "select * from armours where armours.armour_name = '" + ItemName + "';";
				
				ResultSet updateResultOutput = updateSqlStatement.executeQuery(checkUpdateSql);
				
				while(updateResultOutput.next()) {
					armourInfo = new Armours();
					armourInfo.setId(updateResultOutput.getInt("id"));
					armourInfo.setArmour_name(updateResultOutput.getString("armour_name")); 
					armourInfo.setArmour_price(updateResultOutput.getInt("armour_price"));
					armourInfo.setArmour_quantity(updateResultOutput.getInt("armour_quantity"));
					
					System.out.println("The item was successfully updated: "+armourInfo);
				}
				
				System.out.println("Please enter your name: ");
				Scanner nameInput = new Scanner(System.in);
				String userInput = nameInput.next();
				
				if(userInput.equals("Jairus")) {
					System.out.println("Returning to Manager Menu");
					MenuDriver.ManagerMenu();
				}
				else {
					System.out.println("Returning to Employee Menu");
					MenuDriver.EmployeeMenu();
				}
				
			}
			
			else if (ItemCategory.equals("Potions")) {
				
				String updateSql = "update potions set potion_quantity = "+ ItemAmount +" where potion_name = '" + ItemName + "';";
				Statement updateSqlStatement = databaseConnection.createStatement();
				updateSqlStatement.execute(updateSql); 
				
				String checkUpdateSql = "select * from potions where potions.potion_name = '" + ItemName + "';";
				
				ResultSet updateResultOutput = updateSqlStatement.executeQuery(checkUpdateSql);
				
				while(updateResultOutput.next()) {
					potionInfo = new Potions();
					potionInfo.setId(updateResultOutput.getInt("id"));
					potionInfo.setPotion_name(updateResultOutput.getString("potion_name")); 
					potionInfo.setPotion_price(updateResultOutput.getInt("potion_price"));
					potionInfo.setPotion_quantity(updateResultOutput.getInt("potion_quantity"));
					
					System.out.println("The Item was successfully updated: " + potionInfo);
				}	
				
				System.out.println("Please enter your name: ");
				Scanner nameInput = new Scanner(System.in);
				String userInput = nameInput.next();
				
				if(userInput.equals("Jairus")) {
					System.out.println("Returning to Manager Menu");
					MenuDriver.ManagerMenu();
				}
				else {
					System.out.println("Returning to Employee Menu");
					MenuDriver.EmployeeMenu();
				}
			}
			
			else {
				
				System.out.println("There was an error entering the category name");
				System.out.println("Returning to Manager Menu");
				
				MenuDriver.ManagerMenu();
				
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
			int offer = 0; 
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			System.out.println("What are you looking for\nWeapons, Armours, Potions");
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
				
				
				System.out.println("Which weapon do you want?\nPlease enter the name of the weapon\nExample: Dagger");
				String weaponChoice = userInput.next();
				
				String weaponsql = "select * from weapons where weapons.weapon_name = '" + weaponChoice + "';";
				Statement weaponSqlStatement1 = databaseConnection.createStatement();
				ResultSet weaponResultOutput = weaponSqlStatement1.executeQuery(weaponsql);
				
				while(weaponResultOutput.next()) {
					
					weaponInfo = new Weapons();
					weaponInfo.setWeapon_name(weaponResultOutput.getString("weapon_name"));
					weaponInfo.setWeapon_price(weaponResultOutput.getInt("weapon_price"));
					weaponInfo.setWeapon_quantity(weaponResultOutput.getInt("weapon_quantity"));
				
					System.out.println(weaponInfo);
					
					String weapon_Name = weaponInfo.getWeapon_name();
					int weaponPrice = weaponInfo.getWeapon_price();
					System.out.println("The price of your item is: " + weaponPrice + " gold");
					System.out.println("Please enter your offer: ");
					offer = userInput.nextInt();
					
					if (offer < weaponPrice) {
						System.out.println("Not enough gold\nPlease try again");
					}
					else {
						System.out.println("Offer is accepted");
						System.out.println("Please Enter Customer Name");
						String customer_name = userInput.next();
						System.out.println("Creating a transaction");
						CreateTransaction(weapon_Name, customer_name, weaponPrice);					}
				}
				
			}
			
			else if (userSelection.equals("Armours")) {
				
				String armourSQL = "select * from armours;";
				
				Statement armourSqlStatement = databaseConnection.createStatement();
				
				ResultSet updateResultOutput = armourSqlStatement.executeQuery(armourSQL);
				
				while(updateResultOutput.next()) {
					armourInfo = new Armours();
					armourInfo.setId(updateResultOutput.getInt("id"));
					armourInfo.setArmour_name(updateResultOutput.getString("armour_name")); 
					armourInfo.setArmour_price(updateResultOutput.getInt("armour_price"));
					armourInfo.setArmour_quantity(updateResultOutput.getInt("armour_quantity"));
					
					System.out.println(armourInfo);
				}
				
				System.out.println("Which armour do you want?\nPlease enter the name of the armour\nExample: Hide");
				String armourChoice = userInput.next();
				
				String armoursql = "select * from armours where armours.armour_name = '" + armourChoice + "';";
				Statement armourSqlStatement1 = databaseConnection.createStatement();
				ResultSet armour_ResultOutput = armourSqlStatement1.executeQuery(armoursql);
				
				while(armour_ResultOutput.next()) {
					
					armourInfo = new Armours();
					armourInfo.setArmour_name(armour_ResultOutput.getString("armour_name"));
					armourInfo.setArmour_price(armour_ResultOutput.getInt("armour_price"));
					armourInfo.setArmour_quantity(armour_ResultOutput.getInt("armour_quantity"));
				
					System.out.println(armourInfo);
					
					String armourName = armourInfo.getArmour_name();
					int armourPrice = armourInfo.getArmour_price();
					System.out.println("The price of your item is: " + armourPrice + " gold");
					System.out.println("Please enter your offer: ");
					offer = userInput.nextInt();
					
					if (offer < armourPrice) {
						System.out.println("Not enough gold\nPlease try again");
					}
					else {
						System.out.println("Offer is accepted");
						System.out.println("Please Enter Customer Name");
						String customer_name = userInput.next();
						System.out.println("Creating a transaction");
						CreateTransaction(armourName, customer_name, armourPrice);
					}
					
				}


			}
			
			else if (userSelection.equals("Potions")) {
				
				String potionSQL = "select * from potions;";
				
				Statement potionSqlStatement = databaseConnection.createStatement();
				
				ResultSet updateResultOutput = potionSqlStatement.executeQuery(potionSQL);
				
				while(updateResultOutput.next()) {
					potionInfo = new Potions();
					potionInfo.setId(updateResultOutput.getInt("id"));
					potionInfo.setPotion_name(updateResultOutput.getString("potion_name")); 
					potionInfo.setPotion_price(updateResultOutput.getInt("potion_price"));
					potionInfo.setPotion_quantity(updateResultOutput.getInt("potion_quantity"));
					
					System.out.println(potionInfo);
				}
				
				System.out.println("Which potion do you want?\nPlease enter the name of the potion\nExample: Healing");
				String potionChoice = userInput.next();
				
				String potionsql = "select * from potions where potions.potion_name = '" + potionChoice + "';";
				Statement potionSqlStatement1 = databaseConnection.createStatement();
				ResultSet potionResultOutput = potionSqlStatement1.executeQuery(potionsql);
				
				while(potionResultOutput.next()) {
					
					potionInfo = new Potions();
					potionInfo.setPotion_name(potionResultOutput.getString("potion_name"));
					potionInfo.setPotion_price(potionResultOutput.getInt("potion_price"));
					potionInfo.setPotion_quantity(potionResultOutput.getInt("potion_quantity"));
				
					System.out.println(potionInfo);
					
					int potionPrice = potionInfo.getPotion_price();
					String potionName = potionInfo.getPotion_name();
					
					System.out.println("The price of your item is: " + potionPrice + " gold");
					System.out.println("Please enter your offer: ");
					offer = userInput.nextInt();
					
					if (offer < potionPrice) {
						System.out.println("Not enough gold\nPlease try again");
					}
					else {
						System.out.println("Offer is accepted");
						System.out.println("Please Enter Customer Name");
						String customer_name = userInput.next();
						System.out.println("Creating a transaction");
						CreateTransaction(potionName, customer_name, potionPrice);
					}
					
				}


			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public static void ViewTransaction() {
		
		try {
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			System.out.println("Press 1: Search using Transaction Status , 2: Search using Customer Name or 3: Return to Previous Menu");
			Scanner userInput = new Scanner(System.in);
			int transactionSelection = userInput.nextInt();
			
			switch(transactionSelection) {
			
			case 1:
				
				System.out.println("Press 1: Pending Tranactions or 2: Accepted Tranactions");
				Scanner statusInput = new Scanner(System.in);
				int transactionStatusInput = statusInput.nextInt();
				
				switch(transactionStatusInput) {
				
				case 1:
					
					String transactionSQL = "select * from transactions where transactions.transaction_status = 'pending';";
					
					Statement transactionSqlStatement = databaseConnection.createStatement();
					
					ResultSet transactionResultOutput = transactionSqlStatement.executeQuery(transactionSQL);
					
					while(transactionResultOutput.next()) {
						transactionInfo = new Transactions();
						transactionInfo.setId(transactionResultOutput.getInt("id"));
						transactionInfo.setItem_purchased(transactionResultOutput.getString("item_purchased"));
						transactionInfo.setCustomer_name(transactionResultOutput.getString("customer_name"));
						transactionInfo.setTransaction_date(transactionResultOutput.getString("transaction_date"));
						transactionInfo.setTransaction_amount(transactionResultOutput.getInt("transaction_amount"));
						transactionInfo.setTransaction_status(transactionResultOutput.getString("transaction_status"));
						
						System.out.println("Here are your transaction infomation: "+transactionInfo);
					}
					
					System.out.println("Would you like to update one of these transactions to accept?\nPlease Enter Yes or No");
					String YesNo = userInput.next();
					
					if (YesNo.equals("Yes")) {
						System.out.println("Which Transaction Do You want to Update\nExample: Id Number");
						int transactionId = userInput.nextInt();
						
						String updateTransactionSql = "update transactions set transaction_status = 'accepted' where id = '"+transactionId+"';";
						Statement updateTransactionSQLStatement = databaseConnection.createStatement();
						updateTransactionSQLStatement.executeUpdate(updateTransactionSql);
						System.out.println("Please enter your name: ");
						Scanner nameInput = new Scanner(System.in);
						String userInput1 = nameInput.next();
						
						if(userInput1.equals("Jairus")) {
							System.out.println("Returning to Manager Menu");
							MenuDriver.ManagerMenu();
						}
						else {
							System.out.println("Returning to Employee Menu");
							MenuDriver.EmployeeMenu();
						}
					}
					else if(YesNo.equals("No")) {
						System.out.println("Please enter your name: ");
						Scanner nameInput = new Scanner(System.in);
						String userInput1 = nameInput.next();
						
						if(userInput1.equals("Jairus")) {
							System.out.println("Returning to Manager Menu");
							MenuDriver.ManagerMenu();
						}
						else {
							System.out.println("Returning to Employee Menu");
							MenuDriver.EmployeeMenu();
						}
					}
					break;
					
				case 2:
					
					String transactionSQL2 ="select * from transactions where transactions.transaction_status = 'accecpted';";
					
					Statement transactionSQLStatement2 = databaseConnection.createStatement();
					
					ResultSet transactionResultOutput2 = transactionSQLStatement2.executeQuery(transactionSQL2);
					
					while(transactionResultOutput2.next()) {
						transactionInfo = new Transactions();
						transactionInfo.setId(transactionResultOutput2.getInt("id"));
						transactionInfo.setItem_purchased(transactionResultOutput2.getString("item_purchased"));
						transactionInfo.setCustomer_name(transactionResultOutput2.getString("customer_name"));
						transactionInfo.setTransaction_date(transactionResultOutput2.getString("transaction_date"));
						transactionInfo.setTransaction_amount(transactionResultOutput2.getInt("transaction_amount"));
						transactionInfo.setTransaction_status(transactionResultOutput2.getString("transaction_status"));
						
						System.out.println("Here are your transaction infomation: "+transactionInfo);
					}
					
					break;
					
					default:
						System.out.println("Please enter your name: ");
						Scanner nameInput = new Scanner(System.in);
						String userInput1 = nameInput.next();
						
						if(userInput1.equals("Jairus")) {
							System.out.println("Returning to Manager Menu");
							MenuDriver.ManagerMenu();
						}
						else {
							System.out.println("Returning to Employee Menu");
							MenuDriver.EmployeeMenu();
						}
				}
				break;
			case 2:
				
				System.out.println("Please enter the Customer Name for the transaction");
				Scanner customerNameInput = new Scanner(System.in);
				String customerName = customerNameInput.next();
				
				
				String customerTransactionSQL ="select * from transactions where transactions.customer_name  = '"+customerName+"';";
				
				Statement customerTransactionSQLStatement = databaseConnection.createStatement();
				
				ResultSet customerTransactionResultOutput = customerTransactionSQLStatement.executeQuery(customerTransactionSQL);
				
				while(customerTransactionResultOutput.next()) {
					transactionInfo = new Transactions();
					transactionInfo.setId(customerTransactionResultOutput.getInt("id"));
					transactionInfo.setItem_purchased(customerTransactionResultOutput.getString("item_purchased"));
					transactionInfo.setCustomer_name(customerTransactionResultOutput.getString("customer_name"));
					transactionInfo.setTransaction_date(customerTransactionResultOutput.getString("transaction_date"));
					transactionInfo.setTransaction_amount(customerTransactionResultOutput.getInt("transaction_amount"));
					transactionInfo.setTransaction_status(customerTransactionResultOutput.getString("transaction_status"));
					
					System.out.println("Here are your transaction infomation: "+transactionInfo);
				}
				
				System.out.println("Please enter your name: ");
				Scanner nameInput = new Scanner(System.in);
				String userInput1 = nameInput.next();
				
				if(userInput1.equals("Jairus")) {
					System.out.println("Returning to Manager Menu");
					MenuDriver.ManagerMenu();
				}
				else {
					System.out.println("Returning to Employee Menu");
					MenuDriver.EmployeeMenu();
				}
				
				break;
				
			case 3:
				System.out.println("Please enter your name: ");
				Scanner nameInput1 = new Scanner(System.in);
				String userInput11 = nameInput1.next();
				
				if(userInput11.equals("Jairus")) {
					System.out.println("Returning to Manager Menu");
					MenuDriver.ManagerMenu();
				}
				else {
					System.out.println("Returning to Employee Menu");
					MenuDriver.EmployeeMenu();
				}
				break;
				
			default:
				System.out.println("There was an error view the the transaction\nPlease Try Again");
				ViewTransaction(); 
			}			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was an error connecting to the view transaction menu");
			e.printStackTrace();
		}
		
	}
	
	public static void CreateTransaction(String item_purchased, String customer_name, int transaction_amount) {
		
		LocalDate transactionDate = LocalDate.now(); 
		
		try {
			Connection databaseConnection = DriverManager.getConnection(url, username, password);
			
			//System.out.println("Creating Transaction");
			
			String transactionCreationSQL ="insert into transactions (item_purchased, customer_name, transaction_date, transaction_amount, transaction_status) values ('"+item_purchased+"', '"+customer_name+"', '"+transactionDate+"', "+transaction_amount+",'pending');";
			
			Statement transactionCreationSQLStatement = databaseConnection.createStatement();
			
			transactionCreationSQLStatement.executeUpdate(transactionCreationSQL);
			
			System.out.println("The Transaction was Created");
			System.out.println("Returning to Customer Menu");
			
			StoreDriver.OpeningStore();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
}
