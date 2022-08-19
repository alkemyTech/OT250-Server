package com.alkemy.ong.utils;

public enum RoleEnum {
    USER, ADMIN;

    private static final String PREFIX = "ROLE_";
    public String getFullRoleName() {
        return PREFIX + name();
    }
    public String getSimpleRoleName() {
        return name();
    }
}
