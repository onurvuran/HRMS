package com.hrms.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VerificationCode extends User {

	@Column(name = "code")
	private String code;

	@Column(name = "is_verified")
	private boolean isVerified;

	@Column(name = "verified_date")
	private Date VerifiedDate;
	
	@Column(name = "user_id")
	private int userId;

}
