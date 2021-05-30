package com.hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="employers")
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {
	
	@Column(name="company_name")
    private String companyName;
	
	@Column(name="web_address",nullable=false)
	private String  webAdress;
	
	
	@Column(name="phone_number")
   private String phoneNumber;
   
	@Column(name="created_date")
	private LocalDate createdDate;
	
	
	@Column(name="is_active")
   private boolean isActiive;

}
