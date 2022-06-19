package com.revature;

import java.util.Scanner;

public class MenuDriver {

	static Scanner userInput = new Scanner(System.in); 
	
	public static void main(String[] args) {
	
		welcomeMenu(); 
		
		//users testUser = new users(1);

	}
	
	public static void welcomeMenu(){
		
		boolean runningVariable = true; 
		
		do {
			System.out.println("Welcome to the shop \nPlease Enter your Name: ");
			String userName = userInput.nextLine();
			System.out.println("Welcome " + userName + "\nWould you like to 1: Shop, 2: Register, or 3: View Account");
			int userSelection = userInput.nextInt();
			switch(userSelection) {
			case 1:
				System.out.println("Welcome to the Store " + userName);
				runningVariable = false; 
				break;
			case 2:
				System.out.println("Welcome to Account Registeration " + userName);
				runningVariable = false; 
				break; 
			case 3:
				//System.out.println("Welcome to your Account " + userName);
				System.out.println("Please enter your password: "); 
				String userPassword = userInput.nextLine();
				returnName(userName,userPassword); 
				runningVariable = false; 
				break; 
			}
			 
		}while(runningVariable);
		
		userInput.close(); 
		}
	
	public static String returnName(String name, String password) {
		
		//System.out.println(name);
		Users userType = new Users(name,password);
		
		return null;
	}

}
