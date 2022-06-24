package com.revature;

import java.util.Scanner;
import com.revature.database.*;

public class Users  implements UsersInterface {
	
	static Scanner userInput = new Scanner(System.in); 
	
	static String userName;
	static String userPassword; 
	static int userGold; 
	
	private int id;
	private String username;
	private String password;
	private String usertype;
	
	public Users() 
	{
		
	}
	
	public static void AccountLogin() {
		
		DatabaseConnection.RetrieveUserInfo();
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((usertype == null) ? 0 : usertype.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (usertype == null) {
			if (other.usertype != null)
				return false;
		} else if (!usertype.equals(other.usertype))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", usertype=" + usertype + "]";
	}
}


