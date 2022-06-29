package com.revature;

import java.util.Scanner;



import com.revature.database.DatabaseConnection;

public class MenuDriver {

	static Scanner userInput = new Scanner(System.in);
	static String userName; 
	static String userPassword; 
		
	public static void main(String args[]) {
	
		welcomeMenu(); 

	}
	
	public static void welcomeMenu(){
		
		boolean runningVariable = true; 
		
		do {
			System.out.println("Welcome to the shop\n");
			System.out.println("Would you like to 1: Login, 2: Register");
			int userSelection = userInput.nextInt();
			switch(userSelection) {
			case 1:
				System.out.println("Welcome to Login");
				Users.AccountLogin();
				runningVariable = false; 
				break;
			case 2:
				System.out.println("Welcome to Account Registeration ");
				//newUser(); 
				Users.UserCreation();
				runningVariable = false; 
				break; 
			/*
			 * case 3: System.out.println("Welcome to your Account Login");
			 * Users.AccountLogin(); runningVariable = false; break;
			 */
			}
			 
		}while(runningVariable);
		
		userInput.close(); 
		}
	
	public static void ManagerMenu() {
		System.out.println("Welcome to the Manager Menu");
		System.out.println("What would you like to do?");
		System.out.println("1: Update Store, 2: View Empolyees, 3: View Pending Transactions, 4: View Current Items ,5: Exit Program");
		
		int userSelection = userInput.nextInt();
		
		switch(userSelection) {
		
		case 1:
			System.out.println("Please Enter the Category of Item you are updating\nWeapons, Armours, Potions");
			String itemCategory = userInput.next();
			
			System.out.println("Please Enter the Name of the Item you are updating\nExample: Dagger, Hide, or Healing");
			String itemName = userInput.next();
			
			System.out.println("Please Enter the new Quantity of the Item you are updating\nExample: 10, 15, or 20");
			int itemAmount = userInput.nextInt();
			
			System.out.println("Proceeding to Update Store Menu");
			DatabaseConnection.UpdateStore(itemCategory, itemName, itemAmount);
			
			break;
			
		case 2:
			System.out.println("Please enter the Name of Employee you want to look up");
			String employeeName = userInput.next(); 
			
			System.out.println("Proceeding to Employee Menu");
			DatabaseConnection.RetrieveEmployeeInfo(employeeName);
			break;
			
		case 3:
			System.out.println("Proceeding to Transaction Menu");
			DatabaseConnection.ViewTransaction();
			break;
			
		case 4:
			System.out.println("Proceeding to Current Item Menu");
			System.out.println("Please Enter the Category of Items You are Looking For\nExample: Weapons, Armours, Potions");
			String categorySelection = userInput.next();
			
			if(categorySelection.equals("Weapons")) {
				System.out.println("Retrieving Weapons Info");
				DatabaseConnection.RetrieveWeaponInfo();
			}
			else if(categorySelection.equals("Armours")) {
				System.out.println("Retrieving Armours Info");
				DatabaseConnection.RetrieveArmourInfo();
				
			}
			else if(categorySelection.equals("Potions")) {
				System.out.println("Retrieving Potions Info");
				DatabaseConnection.RetrievePotionInfo();
			}
			
			break;
			
		case 5:
			System.out.println("Exiting Program\nThank you Again");
			break;
		}
	} 
	
	
	public static void CustomerMenu() {
		System.out.println("Welcome to the Customer Menu");
		StoreDriver.OpeningStore();
	}
	
	

	

}
