package com.revature.services;

import com.revature.daos.ManagerPostgres;
import com.revature.daos.UsersDAO;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Users;

public class AuthService {

	private UsersDAO ud = new ManagerPostgres();
	
	public Users login(String username, String password) throws UserNotFoundException, LoginException{
		Users principal = ud.getUserByusername(username);
		
		if(principal == null) {
			throw new UserNotFoundException();
		}
		
		if(!principal.getPassword().equals(password)) {
			throw new LoginException();
		}
		
		return principal; 
	}
	
}
