package com.hrms.hrms.api.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.businnes.abstracts.JobService;
import com.hrms.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("api/jobs")
public class JobController {
	private JobService jobService;
     
	@Autowired
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@GetMapping("/getall")
	public List<JobTitle> getAll(){
		return this.jobService.getAll();
		
	}
	

}
