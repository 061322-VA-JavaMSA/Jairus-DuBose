package com.revature.services;

import java.util.List;

import com.revature.models.UserRole;
import com.revature.models.Users;
import com.revature.daos.UsersDAO;
import com.revature.daos.UsersHibernate;
import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;

public class UserService {
	
	private UsersDAO ud = new UsersHibernate();
	
	public Users createUser(Users u) throws UserNotCreatedException {
		u.setRole(UserRole.EMPLOYEE);
		
		Users createdUser = ud.insertUser(u);
		
		if(createdUser.getId() == -1) {
			throw new UserNotCreatedException();
		}
		return createdUser;
	}
	
	public Users getUserById(int id) throws UserNotFoundException{
		Users u = ud.getUserById(id);
		if (u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}

	
	public List<Users> getusers(){
		List<Users> users = ud.getUsers();
		return users; 
	}
}
