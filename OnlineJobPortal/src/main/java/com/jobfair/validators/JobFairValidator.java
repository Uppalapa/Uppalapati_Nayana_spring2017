package com.jobfair.validators;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.util.HtmlUtils;

public class JobFairValidator {

	public static boolean isHtml(String input) {
		boolean isHtml = false;
		if (input != null) {
			if (!input.equals(HtmlUtils.htmlEscape(input))) {
				isHtml = true;
			}
		}
		return isHtml;
	}

	public void validateNumber(String obj, String fieldName, String val, BindingResult result) {

		try {

			Integer.parseInt(val);

		} catch (Exception e) {

			result.addError(new FieldError(obj, fieldName, "Value is non- numeric"));
		}

	}

}
