package com.ashish.security.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.security.repository.IModulePermissionsRepository;
import com.ashish.security.repository.IModulesRepository;
import com.ashish.security.entity.ApplicationModules;
import com.ashish.security.entity.Applications;
import com.ashish.security.entity.ModulePermissions;
import com.ashish.security.entity.Roles;

@Service
public class ModulesService {

	@Autowired
	private IModulesRepository modulesRepository;
	
	@Autowired
	private IModulePermissionsRepository modulePermissionsRepository;
	
	public ApplicationModules findByName(String name) {
		return modulesRepository.findByName(name);
	}
	
	public Set<ModulePermissions> getModulePermissions(Applications application, Set<Roles> roles) {
		return modulePermissionsRepository.findByApplicationAndRoleIn(application, roles);
	}
}
