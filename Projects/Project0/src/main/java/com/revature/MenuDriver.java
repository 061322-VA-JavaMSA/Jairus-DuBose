package com.revature;

import java.util.Scanner;

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
			System.out.println("Would you like to 1: Shop, 2: Register, or 3: View Account");
			int userSelection = userInput.nextInt();
			switch(userSelection) {
			case 1:
				System.out.println("Welcome to the Store ");
				runningVariable = false; 
				break;
			case 2:
				System.out.println("Welcome to Account Registeration ");
				newUser(); 
				runningVariable = false; 
				break; 
			case 3:
				System.out.println("Welcome to your Account Login");
				Users.AccountLogin();
				runningVariable = false; 
				break; 
			}
			 
		}while(runningVariable);
		
		userInput.close(); 
		}
	
	
	public static void newUser() {
		
		Users newUser = new Users();
	}

}
