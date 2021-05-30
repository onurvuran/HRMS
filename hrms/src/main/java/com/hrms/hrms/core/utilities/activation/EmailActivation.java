package com.hrms.hrms.core.utilities.activation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class EmailActivation {
	
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	
	public static boolean isEmailActivation(String emailInput) {
		
		Pattern pattern = Pattern.compile(EMAIL_PATTERN,
	    Pattern.CASE_INSENSITIVE);
     
		return pattern.matcher(emailInput).find();
	}

}
