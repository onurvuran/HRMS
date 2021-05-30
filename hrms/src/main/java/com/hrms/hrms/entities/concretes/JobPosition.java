package com.hrms.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="job_titles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {
     @Id
     @GeneratedValue
     @Column(name="id")
	private int id;
	
     @Column(name="position")
	private String position;
     
     @Column(name="created_date")
     private Date cretedDate;
     
     
     @Column(name="is_active")
     private boolean isActive;
     
     
     

}
