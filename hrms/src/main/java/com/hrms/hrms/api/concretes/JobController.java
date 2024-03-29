package com.hrms.hrms.api.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.businnes.abstracts.JobService;
import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.entities.concretes.JobPosition;

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
	public DataResult<List<JobPosition>> getAll(){
		return this.jobService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobTiltle) {
		return this.jobService.add(jobTiltle);
	}
	

}
