package com.alkemy.ong.exception;

public class NameOrContentAreNull extends RuntimeException{

    private static final String DESCRIPTION = "NAME OR CONTENT ARE NULL OR EMPTY";

    public NameOrContentAreNull(String detail) {
        super(DESCRIPTION + " : " + detail);
    }

}
