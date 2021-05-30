package com.hrms.hrms.core.utilities.adapters.validator.email;

import com.hrms.hrms.entities.concretes.User;

public interface EmailValidationService {
	
	public boolean mailValidation(User user);
	

}
