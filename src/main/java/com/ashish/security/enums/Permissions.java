/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashish.security.enums;

/**
 *
 * @author ashish
 */
public enum Permissions {
    
	HIDE("0"),
	VIEW("1"),
	DELETE("2"),
	ADD("3"),
	EDIT("4");
    
    private final String value;
    
    Permissions(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
}
