package com.revature.daos;

import java.util.List;

import com.revature.models.Users;

public interface UsersDAO {

		Users insertUser(Users u);
		Users getUserById(int id);
		Users getUserByusername(String username);
		
		List<Users>getUsers();
}
