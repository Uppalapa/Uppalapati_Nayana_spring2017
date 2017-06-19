package com.jobfair.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.jobfair.beans.Job;

@Component
public class JobValidator extends JobFairValidator{


	public void validateHTMLSafe(Job job, BindingResult result) {
		
		validate("code", job.getCode(), result);
		validate("position", job.getPosition(), result);
		validate("location", job.getLocation(), result);
		
		validate("primaryskill", job.getPrimaryskill(), result);
		validate("secondaryskill", job.getSecondaryskill(), result);
		validate("otherskills", job.getOtherskills(), result);
		validate("responsibilities", job.getResponsibilities(), result);
		validate("exp", job.getExp(), result);
		validateNumber("job", "exp", job.getExp(), result);
	}
	
	
	private void validate(String fieldName, String val, BindingResult result) {
		
		if(isHtml(val)) {
			
			result.addError(new FieldError("job", fieldName, "Please remove special characters"));
		}
	}
	
	


	/*public static void main(String[] args) {
		
		System.out.println(isHtml("<div>"));
		System.out.println(isHtml("<div></div>"));
		
	}*/
}
