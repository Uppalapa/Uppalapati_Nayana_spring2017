package com.jobfair.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfair.beans.User;
import com.jobfair.dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		User user = userDao.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
       
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
        
        org.springframework.security.core.userdetails.User userDtls =
        
        new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPwd(), grantedAuthorities);
		
   		return userDtls;
	}

	
	
}
