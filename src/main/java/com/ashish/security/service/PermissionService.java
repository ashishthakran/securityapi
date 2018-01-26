package com.ashish.security.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.security.dto.UserPermissionsDto;
import com.ashish.security.entity.ApplicationModules;
import com.ashish.security.entity.Applications;
import com.ashish.security.entity.ModulePermissions;
import com.ashish.security.entity.ModuleSections;
import com.ashish.security.entity.Roles;
import com.ashish.security.entity.SectionFieldPermissions;
import com.ashish.security.entity.SectionPermissions;
import com.ashish.security.entity.Users;
import com.ashish.security.exception.UnAuthorizedUserException;
import com.ashish.security.repository.IUserRepository;

@Service
public class PermissionService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ApplicationsService applicationsService;
	
	@Autowired
	private ModulesService moduleService;
	
	@Autowired
	private SectionService sectionService;
	
	@Transactional
	public UserPermissionsDto getUserPermissions(String applicationCode, String userName) {
		UserPermissionsDto userPermissionDto = new UserPermissionsDto();
		
		Users user = null;
		if(userName.indexOf("@") != -1) {
			user = userRepository.findByEmail(userName);
		} else {
			user = userRepository.findByUsername(userName);
		}
		
		Set<Roles> roles = user.getRoles();		
		Integer hasPermission = applicationsService.hasPermission(applicationCode, roles.stream().map(Roles::getId).collect(Collectors.toList()));
		if(null == hasPermission || hasPermission == 0) {
			throw new UnAuthorizedUserException("Unauthorized access. You don't have access to this application.");
		}

		Applications application = applicationsService.findByCode(applicationCode);		
		Set<ModulePermissions> modules = moduleService.getModulePermissions(application, roles);
		
		modules.forEach(module -> module.getModule().setSections(getModuleSections(module.getModule(), roles)));
		application.setModules(modules);
		
		userPermissionDto.setUser(user);
		userPermissionDto.setApplication(application);
		return userPermissionDto;
	}
	
	private Set<SectionPermissions> getModuleSections(ApplicationModules module, Set<Roles> roles) {
		Set<SectionPermissions> sections = sectionService.getModuleSectionPermissions(module, roles);
		sections.forEach(section -> section.getSection().setFields(getSectionFields(section.getSection(), roles)));
		return sections;
	}
	
	private Set<SectionFieldPermissions> getSectionFields(ModuleSections section, Set<Roles> roles) {
		return sectionService.getSectionFieldPermissions(section, roles);
	}
}
