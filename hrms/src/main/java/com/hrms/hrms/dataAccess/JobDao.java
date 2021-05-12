package com.hrms.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.JobTitle;

public interface JobDao extends JpaRepository<JobTitle,Integer> {

}
