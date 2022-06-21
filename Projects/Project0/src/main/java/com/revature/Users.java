package com.revature;

import java.util.Scanner;

public class Users  implements UsersInterface {
	
	static Scanner userInput = new Scanner(System.in); 
	
	static String userName;
	static String userPassword; 
	static int userGold; 
	
	public Users(String userType, String userPassword) 
	{
		System.out.println("Please Enter Your Name/Username: "); 
		String userName = userInput.nextLine();
		//Users.userName = userType;
		
		System.out.println("Please Enter Your Password: ");
		String userPassword1 = userInput.nextLine();
		//Users.userPassword = userPassword; 
		
		AccountLogin(userType, userPassword1); 
		//System.out.println("This worked " + userType);
	}
	
	public static void AccountLogin(String userType, String userPassword) {
		
		if(userType.equals("Jairus") && userPassword.equals("JaiDuB75")){
			System.out.println("Welcome " + userName + " You are a manager");
		}
		else if (userType.equals("John")&& userPassword.equals("person")) {
			System.out.println("Welcome " + userName + " You are an employee");
		}
		else {
			System.out.println("Welcome " + userName + " You are customer"); 
		}
		
	}

	public void userName() {
		// TODO Auto-generated method stub
		
	}

	public void userPassword() {
		// TODO Auto-generated method stub
		
	}
}
