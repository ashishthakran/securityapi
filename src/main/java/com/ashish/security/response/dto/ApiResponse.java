package com.ashish.security.response.dto;

import java.io.Serializable;

public class ApiResponse<E> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	private boolean status;
	private E result;

	public ApiResponse() {
		
	}
	
	public ApiResponse(String message) {
		this.message = message;
	}
	
	public ApiResponse(boolean status) {
		this.status = status;
	}
	
	public ApiResponse(String message, boolean status) {
		this.message = message;
		this.status = status;
	}
	
	public ApiResponse(boolean status, E result) {
		this.status = status;
		this.result = result;
	}
	
	public ApiResponse(String message, boolean status, E result) {
		this.message = message;
		this.status = status;
		this.result = result;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public E getResult() {
		return result;
	}

	public void setResult(E result) {
		this.result = result;
	}

}
