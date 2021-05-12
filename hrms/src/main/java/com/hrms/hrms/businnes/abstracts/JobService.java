package com.hrms.hrms.businnes.abstracts;

import java.util.List;

import com.hrms.hrms.entities.concretes.JobTitle;

public interface JobService {
	
	List<JobTitle> getAll();

}
