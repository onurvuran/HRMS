package com.hrms.hrms.api.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.businnes.abstracts.EployerService;
import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("api/eployer")
public class EployerController {
	
	private EployerService eployerService;
     
	
	@Autowired
	public EployerController(EployerService eployerService) {
		super();
		this.eployerService = eployerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.eployerService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.eployerService.add(employer);
	}
	
	

}
