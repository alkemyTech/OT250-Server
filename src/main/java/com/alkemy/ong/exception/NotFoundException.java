package com.alkemy.ong.exception;

public class NotFoundException extends RuntimeException{

    private static final String DESCRIPTION = "NOT FOUND EXCEPTION";

    public NotFoundException(String detail) {
        super(DESCRIPTION + " : " + detail);
    }
}
