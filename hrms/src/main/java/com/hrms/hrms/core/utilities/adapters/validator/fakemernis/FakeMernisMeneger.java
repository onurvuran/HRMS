package com.hrms.hrms.core.utilities.adapters.validator.fakemernis;

import org.springframework.stereotype.Service;

import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class FakeMernisMeneger implements FakeMernisService {

	@Override
	public boolean mernisCheck(Candidate candidate) {
		if (candidate.getFirstName().length() < 2) {

			System.out.println("FirstName 2 karakterden az olamaz!");
			return false;

		}
		if (candidate.getLastName().length() < 2) {

			System.out.println("LastName 2 karakterden az olamaz!");
			return false;

		}
		if (candidate.getIdentityNumber().length() != 11) {
			System.out.println("Tc kimlik 11 karakter olmali");
			return false;
		}
		return true;
	}

}
