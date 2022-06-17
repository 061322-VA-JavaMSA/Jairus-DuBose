package com.revature.users;

public class users {
	static String userType;
	
	public users(String userType) 
	{
		this.userType = userType; 
		
		UserTypeSelection(userType); 
		//System.out.println("This worked " + userType);
	}
	
	public static void UserTypeSelection(String userType) {
		
		if(userType.equals("Jairus")){
			System.out.println("Welcome " + userType + " You are a manager");
		}
		else if (userType.equals("John")) {
			System.out.println("Welcome " + userType + " You are an employee");
		}
		else {
			System.out.println("Welcome " + userType + " You are customer"); 
		}
		
	}
}
