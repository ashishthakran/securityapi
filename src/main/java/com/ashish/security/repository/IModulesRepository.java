package com.ashish.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.security.entity.ApplicationModules;

@Repository
public interface IModulesRepository extends JpaRepository<ApplicationModules, String> {

	public ApplicationModules findByName(String name);
}
