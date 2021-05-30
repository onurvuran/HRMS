package com.hrms.hrms.businnes.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.businnes.abstracts.CandidatesService;
import com.hrms.hrms.core.utilities.adapters.validator.email.EmailValidationService;
import com.hrms.hrms.core.utilities.adapters.validator.fakemernis.FakeMernisService;
import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.ErrorResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.core.utilities.result.SuccessDataResult;
import com.hrms.hrms.core.utilities.result.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CandidatesDao;
import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class CandidatesManager implements CandidatesService {

	private CandidatesDao candidatesDao;
	private FakeMernisService fakeMernisService;
//	private EmailValidationService emailValidatorService;

	@Autowired
	public CandidatesManager(CandidatesDao candidatesDao, FakeMernisService fakeMernisService) {
		super();
		this.candidatesDao = candidatesDao;
		this.fakeMernisService = fakeMernisService;
//		this.emailValidatorService = emailValidatorService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidatesDao.findAll(), "Canditates Listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {

		if (candidate.getFirstName().isEmpty()) {
			return new ErrorResult("Firs Name boşo olamaz");
		}

		if (candidate.getLastName().isEmpty()) {
			return new ErrorResult("Lastname boşo olamaz");

		}

		if (candidate.getBirthDate().isEmpty()) {
			return new ErrorResult("Birtday boş boş boşo olamaz");
		}

		if (candidate.getIdentityNumber().isEmpty()) {
			return new ErrorResult("E mail boş bıraılamaz boş boş boşo olamaz");
		}

		if (candidate.getPassword().isEmpty()) {
			return new ErrorResult("Password boş boş boşo olamaz");
		}

		if (candidate.getEmail().isEmpty()) {
			return new ErrorResult("E mail boş bıraılamaz boş boş boşo olamaz");
		}

		if (!candidate.getPassword().equals(candidate.getPasswordRepait()) ) {
			return new ErrorResult("Aynı password giriiz");
		}
		
		if (candidatesDao.findByidentityNumberEquals(candidate.getIdentityNumber())!= null) {
            return new ErrorResult("TC Kimlik Numarası Daha Önce Kullanıldı");
        }

		
		if (candidatesDao.findByEmailEquals(candidate.getEmail())!=null) {
            return new ErrorResult("E-Posta  Daha Önce Kullanıldı");
        }
		
		if(!fakeMernisService.mernisCheck(candidate)) {
			return new ErrorResult("mernis doğrulaması yapılamadı");
		}
		
//		if(emailValidatorService.mailValidation(candidate)) {
//			return new ErrorResult("Eposta dogrulaması başarısız");
//		}
		
		
		
		
		

		return new SuccessResult("kaydoldunuz");
	}





}
