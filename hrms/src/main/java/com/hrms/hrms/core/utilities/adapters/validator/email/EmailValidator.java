package com.hrms.hrms.core.utilities.adapters.validator.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
@Service
public class EmailValidator {
	
	private static final String EMAIL_PATTERN = "(@)(.+)$";
	
	

	
	public static  boolean isEmailValid(String email) {
		
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher  = pattern.matcher(email);
		
		
		if(matcher.matches()==false) {
			
			System.out.println("E-mail tipinde bir veri giriniz."+ email);
			return false;
			
		}
		return true;
	}

	}


