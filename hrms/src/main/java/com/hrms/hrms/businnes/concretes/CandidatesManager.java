package com.hrms.hrms.businnes.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.businnes.abstracts.CandidatesService;
import com.hrms.hrms.core.utilities.adapters.validator.email.EmailValidator;
import com.hrms.hrms.core.utilities.adapters.validator.fakemernis.UserValidationService;
import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.ErrorResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.core.utilities.result.SuccessDataResult;
import com.hrms.hrms.core.utilities.result.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CandidatesDao;
import com.hrms.hrms.entities.concretes.Candidate;
import com.hrms.hrms.entities.concretes.User;


@Service
public class CandidatesManager implements CandidatesService {

	private CandidatesDao candidatesDao;
	private UserValidationService userValidationService;

	@Autowired
	public CandidatesManager(CandidatesDao candidatesDao, UserValidationService userValidationService) {
		super();
		this.candidatesDao = candidatesDao;
		this.userValidationService = userValidationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidatesDao.findAll(), "Canditates Listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {

		if (!validationCondidate(candidate)) {
			return new ErrorResult("Missing data entry.");
		}

		if (!checkIfNationalityId(candidate.getIdentityNumber())) {
			return new ErrorResult("Nationality already exist.");
		}

		if (!checkIfRealPerson(candidate)) {
			return new ErrorResult("Person could not be verified.");
		}

		if (!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Email already exist.");
		}

		if (!checkEmailFormat(candidate.getEmail())) {
			return new ErrorResult("The e-mail information does not meet the required conditions.");
		}

		candidate.setBirthDate(LocalDate.now());
		candidate.setActive(true);

		this.candidatesDao.save(candidate);
		return new SuccessResult("Candidate added.");
	}

	private boolean validationCondidate(Candidate candidate) {
		if (candidate.getEmail() == null && candidate.getPassword() == null && candidate.getFirstName() == null
				&& candidate.getLastName() == null && candidate.getIdentityNumber() == null
				&& candidate.getBirthDate() == null) {
			return false;
		}
		return true;
	}

	private boolean checkIfNationalityId(String identityNumber) {
		if (this.candidatesDao.findByidentityNumber(identityNumber) != null) {
			return false;
		}
		return true;
	}

	private boolean checkIfRealPerson(Candidate candidate) {
		if (!this.userValidationService.CheckIfRealPerson(candidate.getIdentityNumber().isEmpty(),
				candidate.getFirstName().isEmpty(), candidate.getLastName().isEmpty(),
				candidate.getBirthDate())) {
			return false;
		}
		return true;
	}

	private boolean checkIfEmailExists(String emailAddress) {
		if (this.candidatesDao.findByEmail(emailAddress) != null) {
			return false;
		}
		return true;
	}

	private boolean checkEmailFormat(String emailAddress) {
		if (!EmailValidator.isEmailValid(emailAddress)) {
			return false;
		}
		return true;

	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.candidatesDao.findByEmail(email));
	}

	@Override
	public DataResult<Candidate> findByidentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidatesDao.findByidentityNumber(identityNumber));
	}

}
