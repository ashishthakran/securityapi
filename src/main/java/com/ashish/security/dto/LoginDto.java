package com.ashish.security.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String token;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if("".equals(username)) {
			this.username = null;
		} else {
			this.username = username;	
		}		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if("".equals(password)) {
			this.password = null;
		} else {
			this.password = password;	
		}
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
