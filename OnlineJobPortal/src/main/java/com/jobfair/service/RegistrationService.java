package com.jobfair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobfair.beans.User;
import com.jobfair.dao.UserDao;

@Service
public class RegistrationService {
	
	@Autowired
	private UserDao userDao;

	
	public boolean isUserNameExists(final String userName) {
		
		boolean userExists  = false;
		
		User existingUser =  userDao.findByUsername(userName);
		
		if(existingUser != null) {
			
			userExists = true; 
		}
		
		return userExists;
	}
	
	public User addUser(User user) {
		
		if("EMPLOYER".equalsIgnoreCase( user.getRole()) ) {
			user.setStatus("INACTIVE");
		} else {
			user.setStatus("ACTIVE");
		}
		
		return userDao.save(user);
	}

}
