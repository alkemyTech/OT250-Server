package com.alkemy.ong.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String error){super(error);}
}
