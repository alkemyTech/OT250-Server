package com.alkemy.ong.models.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

    @Getter
    @Setter
    @ApiModel(description = "Class representing an Authentication Request.")
    public class AuthRequest {
        @NotNull(message = "the email can't be null")
        @NotEmpty(message = "the email can't be empty")
        @NotBlank(message = "the email can't be blank")
        @Email(message = "the email is not valid")
        @ApiModelProperty(notes = "Email of the User.",
                example = "martin192012@gmail.com", required = true)
        private String email;
        @NotNull(message = "the password can't be null")
        @NotBlank(message = "the password can't be blank")
        @NotEmpty(message = "the password can't be empty")
        @ApiModelProperty(notes = "Password of the User.",
                example = "1234", required = true)
        private String password;
    }

