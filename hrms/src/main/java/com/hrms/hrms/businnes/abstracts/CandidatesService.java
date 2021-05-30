package com.hrms.hrms.businnes.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.entities.concretes.Candidate;
import com.hrms.hrms.entities.concretes.User;

public interface CandidatesService {

	DataResult<List<Candidate>> getAll();

	DataResult<User> findByEmail(String email);

	DataResult<Candidate> findByidentityNumber(String identityNumber);

	Result add(Candidate candidates);

}
