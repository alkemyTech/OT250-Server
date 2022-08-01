package com.alkemy.ong.controller.error;

import com.alkemy.ong.exception.*;
import com.alkemy.ong.models.response.ApiErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ParamNotFoundException.class})
    protected ResponseEntity<Object> handleParamNotFound(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                Arrays.asList("Param Not Found")
        );
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {SlideNotFoundException.class})
    protected ResponseEntity<Object> handleSlideNotFound(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                Arrays.asList("Slide Not Found")
        );
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {CategoryNotFoundException.class})
    protected ResponseEntity<Object> handleCategoryNotFound(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                Arrays.asList("Category Not Found")
        );
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {OrgNotFoundException.class})
    protected ResponseEntity<Object> handleOrganizationNotFound(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                Arrays.asList("Organization Not Found")
        );
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    @ExceptionHandler(value = {UsernameNotFoundException.class})
    protected ResponseEntity<Object> UsernameNotFound(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                Arrays.asList("Username Not Found")
        );
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {ActivityNotFoundException.class})
    protected ResponseEntity<Object> activityNotFound(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                Arrays.asList("Activity Not Found")
        );
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {NameOrEmailAreNull.class})
    protected ResponseEntity<Object> nameOrEmailAreNull(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                Arrays.asList("name or email are Null")
        );
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {NameOrContentAreNull.class})
    protected ResponseEntity<Object> nameOrContentAreNull(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                Arrays.asList("name or content are Null")
        );
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
