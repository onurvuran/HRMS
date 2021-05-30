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
@EqualsAndHashCode(callSuper=false)
@Table(name="employees")
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Eployee extends User {
	

	
	@Column(name="first_name")
	private String firstNane;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="is_active")
	private boolean isAnctive;

}
