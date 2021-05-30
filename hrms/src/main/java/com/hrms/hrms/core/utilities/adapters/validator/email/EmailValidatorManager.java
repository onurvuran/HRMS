package com.hrms.hrms.core.utilities.adapters.validator.email;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class EmailValidatorManager   implements EmailValidationService {

	@Override
	public boolean sendVerificationCode(String email, String code) {
		System.out.println(email + " mail adresine kod gönderildi. Doğrulama Kodu: " + code);
		return true;	}

	@Override
	public String codeGenerator() {
		
		
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
		
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
	
		
		for (int i = 0; i < 10; i++)
		{
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}

		return sb.toString();
	}

}
