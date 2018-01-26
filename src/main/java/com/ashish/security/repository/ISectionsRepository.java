package com.ashish.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.security.entity.ApplicationModules;
import com.ashish.security.entity.ModuleSections;

@Repository
public interface ISectionsRepository extends JpaRepository<ModuleSections, String> {

	public ModuleSections findByModuleAndName(ApplicationModules module, String name);
}
