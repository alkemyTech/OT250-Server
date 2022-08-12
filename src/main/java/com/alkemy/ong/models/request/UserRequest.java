package com.alkemy.ong.models.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Class representing an User Request.")
public class UserRequest {
    @NotNull(message = "the firstName can't be null")
    @NotEmpty(message = "the firstName can't be empty")
    @NotBlank(message = "the firstName can't  be blank")
    @ApiModelProperty(notes = "First name of the User.",
            example = "Jessica", required = true)
    private String firstName;

    @NotNull(message = "the lastName can't be null")
    @NotEmpty(message = "the lastName can't be empty")
    @NotBlank(message = "the lastName can't  be blank")
    @ApiModelProperty(notes = "Last name of the User.",
            example = "Abigail", required = true)
    private String lastName;

    @NotNull(message = "the email can't be null")
    @Email(message = "the email is not valid")
    @ApiModelProperty(notes = "Email of the User.",
            example = "jessica.abigail@email.com", required = true)
    private String email;

    @NotNull(message = "the password can't be null")
    @NotEmpty(message = "the password can't be empty")
    @NotBlank(message = "the password can't  be blank")
    @ApiModelProperty(notes = "Password of the User.",
            example = "jessica.abigail", required = true)
    private String password;
    @ApiModelProperty(notes = "Photo encoded in Base64 of the User.")
    private String photo;

}
