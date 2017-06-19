package com.jobfair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobfair.beans.User;
import com.jobfair.service.AdminService;
import com.jobfair.service.EmailService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AdminService service;
		
	@Autowired
	private EmailService emailSvc;
	
	@RequestMapping(value = "/allEmps", method = RequestMethod.GET)
	public ModelAndView viewAllEmployers() {
				
		List<User> empsList = service.getAllEmployers();
				
		return new ModelAndView("admin/listemps", "users", empsList);
	}
	
	@RequestMapping(value = "/viewEmp/{userName}", method = RequestMethod.GET)
	public ModelAndView viewEmployer(@PathVariable("userName") String userName) {
				
		User emp = service.getEmployer(userName);
				
		return new ModelAndView("admin/viewemp", "user", emp);
	}
	
	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public ModelAndView updateEmployer(@ModelAttribute User user) {
				
		service.updateEmpStatus(user.getUserid(), user.getStatus());
		
		emailSvc.sendMailToEmployer(user.getUserid());
		
		List<User> empsList = service.getAllEmployers();
						
		return new ModelAndView("admin/listemps", "users", empsList);
	}
	
	

}
