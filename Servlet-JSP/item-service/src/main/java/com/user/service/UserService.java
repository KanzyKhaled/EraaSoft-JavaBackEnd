package com.user.service;

import com.user.model.User;

public interface UserService {

		boolean createUser(User user);
	    User getUserByUsername(String username); 
	   // boolean updateUser(User user); 
	   // boolean deleteUser(int userId); 
	    boolean isUsernameAvailable(String username); // Check if username exists
	}

	

