package com.hrms.hrms.businnes.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.entities.concretes.Candidate;

public interface CandidatesService {

	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidates);

}
