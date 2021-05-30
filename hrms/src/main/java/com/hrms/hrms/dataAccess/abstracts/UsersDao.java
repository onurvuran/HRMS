package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.User;

public interface UsersDao extends JpaRepository<User,Integer> {
	User findByEmail(String email);
}
