package com.jobfair.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contextPath", request.getContextPath());

		return new ModelAndView("index", model);
	}
	
	/**
	 * Home Page. After Login , based on the user role, respective dashboard page will appear.
	 * @return 
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		
		 UserDetails userDetails =
				  (UserDetails)SecurityContextHolder.getContext().
				  getAuthentication().getPrincipal();
		 
		 
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		
		GrantedAuthority auth = (GrantedAuthority) authorities.toArray()[0];
		
		String role = auth.getAuthority();
		
		String viewName = "";
		
		if("ROLE_ADMIN".equalsIgnoreCase(role)) {
			
			viewName = "admin/home";
		
		}else if("ROLE_EMPLOYER".equalsIgnoreCase(role)){
			
			viewName = "emp/home";
			
		}else if("ROLE_JOBSEEKER".equalsIgnoreCase(role)){
			
			viewName = "jobSeeker/home";
		}
		
		return   viewName;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from JobFair.com successfully.");
		}

		model.setViewName("login");
		return model;
	}

}
