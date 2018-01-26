package com.ashish.security.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ashish.security.entity.Applications;
import com.ashish.security.entity.Users;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPermissionsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Users user;
	private Applications application;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Applications getApplication() {
		return application;
	}

	public void setApplication(Applications application) {
		this.application = application;
	}
}
