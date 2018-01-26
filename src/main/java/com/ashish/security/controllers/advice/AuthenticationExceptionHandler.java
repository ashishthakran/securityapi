package com.ashish.security.controllers.advice;

import java.security.NoSuchAlgorithmException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ashish.security.response.dto.ApiResponse;

@ControllerAdvice
public class AuthenticationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { BadCredentialsException.class, UsernameNotFoundException.class, NoSuchAlgorithmException.class })
	protected ResponseEntity<ApiResponse<?>> badCredentials(RuntimeException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiResponse<>(ex.getMessage(), false));
	}
}
