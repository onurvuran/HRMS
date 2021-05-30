package com.hrms.hrms.core.utilities.adapters.validator.email;

import org.springframework.stereotype.Service;

import com.hrms.hrms.entities.concretes.User;

@Service
public class EmailValidatorManager implements EmailValidationService {

	@Override
	public boolean mailValidation(User user) {
		
		return true;
	}





}
