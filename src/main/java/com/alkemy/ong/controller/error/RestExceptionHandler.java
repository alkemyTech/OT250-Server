package com.alkemy.ong.controller.error;

import com.alkemy.ong.exception.*;
import com.alkemy.ong.models.response.ApiErrorResponse;
import com.amazonaws.services.apigateway.model.BadRequestException;
import com.amazonaws.services.codestar.model.UserProfileAlreadyExistsException;
import com.amazonaws.services.pinpoint.model.ForbiddenException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    @ExceptionHandler(value = {UserProfileAlreadyExistsException.class})
    protected ResponseEntity<Object> userProfileAreadyExists(RuntimeException ex, WebRequest request) {
		ApiErrorResponse error = new ApiErrorResponse(
				HttpStatus.CONFLICT,
				ex.getMessage(),
				Arrays.asList("Email Aready Exists")
				);
    	return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
    	
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
                HttpStatus.NO_CONTENT,
                ex.getMessage(),
                Arrays.asList("name or email are Null")
        );
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NO_CONTENT, request);
    }

    @ExceptionHandler(value = {NameOrContentAreNull.class})
    protected ResponseEntity<Object> nameOrContentAreNull(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.NO_CONTENT,
                ex.getMessage(),
                Arrays.asList("name or content are Null")
        );
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NO_CONTENT, request);
    }

    @ExceptionHandler(value = {ForbiddenException.class})
    protected ResponseEntity<Object> ForbiddenExceptionHandler(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.FORBIDDEN,
                ex.getMessage(), null
        );
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> NotFoundExceptionHandler(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage(), null
        );
        ex.printStackTrace();

        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    protected ResponseEntity<Object> BadRequestExceptionHandler(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(), null
        );
        ex.printStackTrace();

        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {BodyIsNullException.class})
    protected ResponseEntity<Object> BodyIsNullException(RuntimeException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.NO_CONTENT,
                ex.getMessage(),
                Arrays.asList("body is empty or Null")
        );
        ex.printStackTrace();

        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NO_CONTENT, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        ApiErrorResponse errorDTO = new ApiErrorResponse(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(
                ex, errorDTO, headers, errorDTO.getStatus(), request
        );
    }
}
