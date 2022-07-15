package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.UserRole;
import com.revature.models.Users;
import com.revature.services.UserService;
import com.revature.util.CorsFix;

public class UserServlets extends HttpServlet{

		private static final long serialversionUID = 1L;
		private UserService us = new UserService(); 
		private ObjectMapper om = new ObjectMapper(); 
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			CorsFix.addCorsHeader(req.getRequestURI(), res);
			res.addHeader("Content-Type", "application/json");



			String pathInfo = req.getPathInfo();

			if (pathInfo == null) {


				HttpSession session = req.getSession();

				if (session.getAttribute("userRole")!= null && session.getAttribute("userRole").equals(UserRole.MANAGER)) {
					// retrieving users from db using UserService
					List<Users> users = us.getusers();
					List<UserDTO> usersDTO = new ArrayList<>();

					users.forEach(u -> usersDTO.add(new UserDTO(u)));

					PrintWriter pw = res.getWriter();
					pw.write(om.writeValueAsString(usersDTO));

					pw.close();
				}else {
					res.sendError(401, "Unauthorized request.");
				}
			} else {
				int id = Integer.parseInt(pathInfo.substring(1));

				try (PrintWriter pw = res.getWriter()) {
					Users u = us.getUserById(id);
					UserDTO uDTO = new UserDTO(u);

					pw.write(om.writeValueAsString(uDTO));

					res.setStatus(200);
				} catch (UserNotFoundException e) {
					res.setStatus(404);
					e.printStackTrace();
				}
			}
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			InputStream reqBody = req.getInputStream();

			Users newUser = om.readValue(reqBody, Users.class);

			try {
				us.createUser(newUser);

				res.setStatus(201); // Status: Created
			} catch (UserNotCreatedException e) {
				res.sendError(400, "Unable to create new user.");
				e.printStackTrace();
			}
		}
		
}
