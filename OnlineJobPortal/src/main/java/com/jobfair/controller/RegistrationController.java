package com.jobfair.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobfair.beans.User;
import com.jobfair.service.RegistrationService;
import com.jobfair.util.UserRoles;
import com.jobfair.validators.UserValidator;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@Autowired
	private UserValidator validator;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@ModelAttribute User user, ModelMap map ) {
		
		return goToFormEntry(map);
	}
	
	@RequestMapping(value = "/registerSubmit", method = RequestMethod.POST)
	public ModelAndView registerSubmit(@Valid @ModelAttribute  User user,  BindingResult result, ModelMap map ) {
		
		validator.validateHTMLSafe(user, result);
			
		if(service.isUserNameExists(user.getUsername())) {
			result.addError(new FieldError("user", "username", "UserName already exists"));
		}
		
		if (result.hasErrors()) {
			
			return goToFormEntry(map);
        } 
			
		user = service.addUser(user);
		
		return new ModelAndView("success", "user", user);
	}

	private ModelAndView goToFormEntry(ModelMap map) {
		
		map.put("roles", UserRoles.list());
		
		return new ModelAndView("register", "model", map);
	}

}
