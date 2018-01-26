package com.ashish.security.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.security.repository.ISectionFieldPermissionsRepository;
import com.ashish.security.repository.ISectionPermissionsRepository;
import com.ashish.security.repository.ISectionsRepository;
import com.ashish.security.entity.ApplicationModules;
import com.ashish.security.entity.ModuleSections;
import com.ashish.security.entity.Roles;
import com.ashish.security.entity.SectionFieldPermissions;
import com.ashish.security.entity.SectionPermissions;

@Service
public class SectionService {

	@Autowired
	private ISectionsRepository sectionsRepository;
	
	@Autowired
	private ISectionPermissionsRepository sectionPermissionsRepository;
	
	@Autowired
	private ISectionFieldPermissionsRepository sectionFieldPermissionsRepository;
	
	public ModuleSections findModuleSection(ApplicationModules module, String name) {
		return sectionsRepository.findByModuleAndName(module, name);
	}
	
	public Set<SectionPermissions> getModuleSectionPermissions(ApplicationModules module, Set<Roles> roles) {
		return sectionPermissionsRepository.findByModuleAndRoleIn(module, roles);
	}
	
	public Set<SectionFieldPermissions> getSectionFieldPermissions(ModuleSections section, Set<Roles> roles) {
		return sectionFieldPermissionsRepository.findBySectionAndRoleIn(section, roles);
	}
}
