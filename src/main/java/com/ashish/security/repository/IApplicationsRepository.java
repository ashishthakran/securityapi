package com.ashish.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.security.entity.Applications;

@Repository
public interface IApplicationsRepository extends JpaRepository<Applications, String> {

	public Applications findByCode(String code);
}
