package com.ashish.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.security.entity.Users;

@Repository
public interface IUserRepository extends JpaRepository<Users, String> {

	public Users findByUsername(String username);
	
	public Users findByEmail(String email);
	
	public Users findByUsernameAndStatus(String username, String status);
	
	public Users findByEmailAndStatus(String email, String status);
}
