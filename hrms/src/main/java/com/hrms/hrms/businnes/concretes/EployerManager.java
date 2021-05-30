package com.hrms.hrms.businnes.concretes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.businnes.abstracts.EployerService;
import com.hrms.hrms.core.utilities.adapters.validator.email.EmailValidator;
import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.ErrorResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.core.utilities.result.SuccessDataResult;
import com.hrms.hrms.core.utilities.result.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.Employer;
@Service
public class EployerManager implements EployerService {
	private EmployerDao employerDao;

	@Autowired
	public EployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}

	@Override
	public Result add(Employer employer) {

		if (!validationEmployer(employer)) {
			return new ErrorResult("Missing data entry.");
		}

		if (!checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult("Email already exist.");
		}

		if (!checkEmailFormat(employer.getEmail())) {
			return new ErrorResult("The e-mail information does not meet the required conditions.");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getEmail())) {
			return new ErrorResult("Email and website do not have the same domain.");
		}

		employer.setCreatedDate(LocalDate.now());
		employer.setIsMailVerify(true);

		this.employerDao.save(employer);

		return new SuccessResult("Employer added.");
	}

	private boolean validationEmployer(Employer employer) {
		if (employer.getEmail() == null && employer.getPassword() == null && employer.getCompanyName() == null
				&& employer.getEmail() == null) {
			return false;
		}
		return true;
	}

	private boolean checkIfEmailExists(String email) {
		if (this.employerDao.findByEmail(email) != null) {
			return false;
		}
		return true;
	}

	private boolean checkEmailFormat(String email) {
		if (!EmailValidator.isEmailValid(email)) {
			return false;
		}
		return true;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String website) {

		String[] webAdressKeywords = { "www", "http://www", "https://www" };

		String[] emailDomain = email.split("@", 2);

		String domain = "";
		String[] websiteDomain = website.split("\\.", 2);
		if (Arrays.asList(webAdressKeywords).contains(websiteDomain[0])) {
			domain = websiteDomain[1];
		} else {
			domain = website;
		}

		if (!emailDomain[1].equals(domain)) {
			System.out.println("Domain hatası");
			return false;
		}
		return true;
	}
}
