package com.revature;

public class Users  implements UsersInterface {
	
	static String userType;
	static String userPassword; 
	static int userGold; 
	
	public Users(String userType, String userPassword) 
	{
		Users.userType = userType;
		Users.userPassword = userPassword; 
		
		AccountLogin(userType, userPassword); 
		//System.out.println("This worked " + userType);
	}
	
	public static void AccountLogin(String userType, String userPassword) {
		
		if(userType.equals("Jairus") && userPassword.equals("JaiDuB75")){
			System.out.println("Welcome " + userType + " You are a manager");
		}
		else if (userType.equals("John")) {
			System.out.println("Welcome " + userType + " You are an employee");
		}
		else {
			System.out.println("Welcome " + userType + " You are customer"); 
		}
		
	}

	public void userName() {
		// TODO Auto-generated method stub
		
	}

	public void userPassword() {
		// TODO Auto-generated method stub
		
	}
}
