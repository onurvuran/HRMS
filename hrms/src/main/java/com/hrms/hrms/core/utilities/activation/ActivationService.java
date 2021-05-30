package com.hrms.hrms.core.utilities.activation;

public interface ActivationService {
	
	void sendActivationCode(String email);
	String codeGenerator();

}
