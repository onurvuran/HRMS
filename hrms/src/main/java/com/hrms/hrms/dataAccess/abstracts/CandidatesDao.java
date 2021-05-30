package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.Candidate;

public interface CandidatesDao extends JpaRepository<Candidate,Integer> {
	
	 
	  Candidate findByidentityNumber(String identityNumber);
	  Candidate findByEmail(String emailAddress);

}