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
public enum ApplicationName {

    LOS("LOS");

    private final String name;

    private ApplicationName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
