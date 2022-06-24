package com.revature;

import java.util.Scanner;
import com.revature.database.*;

public class StoreDriver {

	static Scanner userInput = new Scanner(System.in); 
	
	public static void OpeningStore() {
		// TODO Auto-generated method stub

		System.out.println("What can I get you?\n 1: Weapons 2: Armours 3: Potions");
		int userSelection = userInput.nextInt();
		switch(userSelection) {
		
		case 1:
			System.out.println("Welcome to Weapons");
			DatabaseConnection.RetrieveWeaponInfo();
			break;
		case 2:
			System.out.println("Welcome to Armours");
			DatabaseConnection.RetrieveArmourInfo();
			break; 
		case 3:
			System.out.println("Welcome to Potions");
			DatabaseConnection.RetrievePotionInfo();
			break;
		default:
			System.out.println("Invalid Input Please Try Again");
		
		}
	}
	
	public static void StoreTestMethod() {
		
		System.out.println("Testing the Store Driver"); 
		
	}

}
