/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashish.security.common.enums;

/**
 *
 * @author ashish
 */
public enum Status {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String value;

    private Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
