package com.revature;

import java.util.Scanner;

public class Users  implements UsersInterface {
	
	static Scanner userInput = new Scanner(System.in); 
	
	static String userName;
	static String userPassword; 
	static int userGold; 
	
	public Users() 
	{
		System.out.println("Please Enter Your Name/Username: "); 
		String userName = userInput.nextLine();
		
		
		System.out.println("Please Enter Your Password: ");
		String userPassword = userInput.nextLine();
		 
		
		NewUserLogin(userName, userPassword);  
		
	}
	
	public static void AccountLogin() {
		
		System.out.println("Please enter your username: ");
		String userName = userInput.nextLine();
		
		System.out.println("Please enter your password: ");
		String userPassword = userInput.nextLine(); 
		
		if(userName.equals("Jairus") && userPassword.equals("JaiDuB75")){
			System.out.println("Welcome " + userName + " You are a manager");
		}
		else if (userName.equals("John")&& userPassword.equals("person")) {
			System.out.println("Welcome " + userName + " You are an employee");
		}
		else {
			System.out.println("We could not find your account please try again"); 
		}
		
	}
	
	public void NewUserLogin(String userName, String userPassword) {
		
		System.out.println("Welcome " + userName + " You are a customer");
	}

	public void userName() {
		// TODO Auto-generated method stub
		
	}

	public void userPassword() {
		// TODO Auto-generated method stub
		
	}
}
