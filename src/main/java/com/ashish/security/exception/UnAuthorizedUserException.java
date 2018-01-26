package com.ashish.security.exception;

import org.springframework.security.core.AuthenticationException;

public class UnAuthorizedUserException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public UnAuthorizedUserException(String msg) {
		super(msg);
	}

	public UnAuthorizedUserException(String msg, Throwable t) {
		super(msg, t);
	}
}
