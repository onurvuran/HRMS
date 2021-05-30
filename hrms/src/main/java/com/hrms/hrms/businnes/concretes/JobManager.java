package com.hrms.hrms.businnes.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.businnes.abstracts.JobService;
import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.core.utilities.result.SuccessDataResult;
import com.hrms.hrms.core.utilities.result.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.hrms.entities.concretes.JobPosition;

@Service
public class JobManager implements JobService {
	private JobPositionDao jobDao;
	
	
     @Autowired
	public JobManager(JobPositionDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
  public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobDao.findAll(),"Jobtitle listelendi");  //this.jobDao.findAll();
	}

	@Override
	public Result add(JobPosition jobTitle) {
		this.jobDao.save(jobTitle);
		return new SuccessResult("Job eklendi.");
	}
	
	

}
