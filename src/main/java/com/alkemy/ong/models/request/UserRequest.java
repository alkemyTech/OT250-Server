package com.alkemy.ong.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotNull
    @NotEmpty(message = "the first name can't be null")
    @NotBlank(message = "the first name can't  be blank")
    private String firstName;

    @NotNull
    @NotEmpty(message = "the last name can't be null")
    @NotBlank(message = "the last name can't  be blank")
    private String lastName;

    @NotNull
    @Email(message = "the email is not valid")
    private String email;

    @NotNull
    @NotEmpty(message = "the password can't be null")
    private String password;

    private String photo;

}
