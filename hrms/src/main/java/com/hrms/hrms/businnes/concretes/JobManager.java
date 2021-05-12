package com.hrms.hrms.businnes.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.businnes.abstracts.JobService;
import com.hrms.hrms.dataAccess.JobDao;
import com.hrms.hrms.entities.concretes.JobTitle;

@Service
public class JobManager implements JobService {
	private JobDao jobDao;
	
	
     @Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public List<JobTitle> getAll() {
		
		return this.jobDao.findAll();
	}
	
	

}
