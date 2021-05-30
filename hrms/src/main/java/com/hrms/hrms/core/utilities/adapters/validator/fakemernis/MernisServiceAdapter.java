package com.hrms.hrms.core.utilities.adapters.validator.fakemernis;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
@Service
public class MernisServiceAdapter implements UserValidationService  {
	@Override
	public boolean CheckIfRealPerson(boolean nationalityId, boolean firstName, boolean lastName, LocalDate birthDate) {
		// TODO Auto-generated method stub
		return true;
	}

}
