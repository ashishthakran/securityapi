package com.ashish.security.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.security.dto.LoginDto;
import com.ashish.security.dto.UserPermissionsDto;
import com.ashish.security.response.dto.ApiResponse;
import com.ashish.security.service.AuthenticationService;
import com.ashish.security.service.PermissionService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api/v0/security")
public class SecurityController {

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private PermissionService permissionService;
	
	@PostMapping(value = "/authenticate", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ApiResponse<?>> authenticate(@RequestBody(required = true) LoginDto loginDto) throws NoSuchAlgorithmException {
		authenticationService.authenticate(loginDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Token", UUID.randomUUID().toString());
		return ResponseEntity.ok().headers(headers).body(new ApiResponse<>(true));
	}

	@GetMapping(value = "/{userName:.+}/permissions", produces = "application/json")
	public ResponseEntity<UserPermissionsDto> getPermissions(
			@RequestHeader(value = "applicationCode", required = true) String applicationCode,
			@PathVariable(required = true) String userName) throws JsonProcessingException {
		UserPermissionsDto userPermissionDto = permissionService.getUserPermissions(applicationCode, userName);
		return new ResponseEntity<UserPermissionsDto>(userPermissionDto, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/{userName:.+}/validate", produces = "application/json")
	public ResponseEntity<ApiResponse<?>> validUser(
			@RequestHeader(value = "applicationCode", required = true) String applicationCode,
			@PathVariable(required = true) String userName) throws JsonProcessingException {
		authenticationService.isValidUser(userName);
		return ResponseEntity.ok().body(new ApiResponse<>(true));
	}
	
	@GetMapping(value = "/{userName:.+}/forgotpassword", produces = "application/json")
	public ResponseEntity<ApiResponse<?>> forgotPassword(
			@RequestHeader(value = "applicationCode", required = true) String applicationCode,
			@PathVariable(required = true) String userName) throws JsonProcessingException {
		authenticationService.forgotPassword(userName);
		return ResponseEntity.ok().body(new ApiResponse<>(true));
	}
	
}
