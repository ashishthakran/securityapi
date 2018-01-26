package com.ashish.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.security.repository.IApplicationPermissionsRepository;
import com.ashish.security.repository.IApplicationsRepository;
import com.ashish.security.entity.Applications;

@Service
public class ApplicationsService {

	@Autowired
	private IApplicationsRepository applicationsRepository;
	
	@Autowired
	private IApplicationPermissionsRepository applicationPermissionsRepository;
	
	public Applications findByCode(String code) {
		return applicationsRepository.findByCode(code);
	}
	
	public Integer hasPermission(String applicationCode, List<String> roles) {
		return applicationPermissionsRepository.hasPermissions(applicationCode, roles);
	}
}
