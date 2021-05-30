package com.hrms.hrms.core.utilities.adapters.validator.email;

public interface EmailValidationService {
	
	boolean sendVerificationCode(String email,String code);
	
	String codeGenerator();
	

}
