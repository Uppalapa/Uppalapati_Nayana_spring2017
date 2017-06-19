package com.jobfair.dao;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jobfair.beans.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

	public User findByUsername(String username);
	
	public List<User> findByRole(String role);
}
