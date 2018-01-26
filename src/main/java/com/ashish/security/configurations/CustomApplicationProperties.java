/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashish.security.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author ashish
 */
@Component
public class CustomApplicationProperties {
	
	@Value("${password.encoding.multiplication}")
	private Short passwordEncodingMultiplication;

	public Short getPasswordEncodingMultiplication() {
		return passwordEncodingMultiplication;
	}

	public void setPasswordEncodingMultiplication(Short passwordEncodingMultiplication) {
		this.passwordEncodingMultiplication = passwordEncodingMultiplication;
	}
}
