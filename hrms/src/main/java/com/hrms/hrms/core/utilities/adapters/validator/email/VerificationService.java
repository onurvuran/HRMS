package com.hrms.hrms.core.utilities.adapters.validator.email;

public interface VerificationService {
	
	void sendLink(String email);
	String sendCode();

}
