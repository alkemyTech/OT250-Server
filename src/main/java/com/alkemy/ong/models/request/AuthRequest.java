package com.alkemy.ong.models.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

    @Getter
    @Setter
    public class AuthRequest {
        @NotNull
        @NotEmpty(message = "the email can't be null")
        @NotBlank(message = "the email can't be blank")
        @Email(message = "Email is not valid")
        private String email;
        @NotNull
        @NotBlank(message = "the password can't be blank")
        @NotEmpty(message = "the password can't be null")
        private String password;
    }

