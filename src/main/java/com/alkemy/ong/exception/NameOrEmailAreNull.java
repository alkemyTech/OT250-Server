package com.alkemy.ong.exception;

public class NameOrEmailAreNull extends RuntimeException{

    private static final String DESCRIPTION = "NAME OR EMAIL ARE NULL OR EMPTY";

    public NameOrEmailAreNull(String detail) {
        super(DESCRIPTION + " : " + detail);
    }

}
