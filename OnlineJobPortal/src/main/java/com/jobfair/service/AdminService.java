package com.jobfair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobfair.beans.User;
import com.jobfair.dao.UserDao;

@Service
public class AdminService {
	
	@Autowired
	private UserDao userDao;
		
	public List<User> getAllEmployers() {
		
		List<User> empsList = userDao.findByRole("EMPLOYER");
		
		return empsList;
	}
	
	public User getEmployer(final String userName) {
		
		User emp = userDao.findByUsername(userName);
		
		return emp;
	}

	public User updateEmpStatus(final long userId, final String status) {
				
		User user = userDao.findOne(userId);
		
		user.setStatus(status);
		
		return userDao.save(user);
	}
	
}
