package com.hrms.hrms.businnes.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.entities.concretes.Employer;

public interface EployerService {

	DataResult<List<Employer>> getAll();

	DataResult<Employer> getByEmail(String email);

	Result add(Employer employer);

}
