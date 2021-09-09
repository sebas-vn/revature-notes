package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.User;
import com.revature.repositories.IUserDao;
import com.revature.repositories.UserDao;

public class UserService {
	// Directly injecting the interface spoecifications and class that Service depends on
	public IUserDao udao = new UserDao();
	private static Logger log = Logger.getLogger(UserService.class);

	public User register(User u) { 
		
		if(u.getId() != 0) {
			
			throw new RegisterUserFailedException("Received User Object did not have an id of 0");
		}
		
		int generatedId = udao.insert(u);
		
		if(generatedId != -1 && generatedId != u.getId()) {
			// fairly certain that the insert operation was seccessfull
			u.setId(generatedId);
		} else {
			throw new RegisterUserFailedException("Failed to insert the user");
		}
		
		log.info("Registration of user with id " + u.getId() + " was successful.");
		
		return u;
		
	}

}
