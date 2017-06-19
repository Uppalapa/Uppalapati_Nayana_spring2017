package com.jobfair.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.jobfair.beans.User;

@Component
public class UserValidator extends JobFairValidator{


	public void validateHTMLSafe(User user, BindingResult result) {
		
		validate("username", user.getUsername(), result);
		validate("name", user.getName(), result);
		validate("address", user.getAddress(), result);
		validate("phone", user.getPhone(), result);
		validate("myself", user.getMyself(), result);
	}
	
	
	private void validate(String fieldName, String val, BindingResult result) {
		
		if(isHtml(val)) {
			
			result.addError(new FieldError("user", fieldName, "Please remove special characters"));
		}
	}
	
	
}
