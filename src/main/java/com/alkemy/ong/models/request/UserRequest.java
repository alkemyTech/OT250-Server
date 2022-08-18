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
            example = "Martin", required = true)
    private String firstName;

    @NotNull(message = "the lastName can't be null")
    @NotEmpty(message = "the lastName can't be empty")
    @NotBlank(message = "the lastName can't  be blank")
    @ApiModelProperty(notes = "Last name of the User.",
            example = "Gutierrez", required = true)
    private String lastName;

    @NotNull(message = "the email can't be null")
    @Email(message = "the email is not valid")
    @ApiModelProperty(notes = "Email of the User.",
            example = "martin192012@gmail.com", required = true)
    private String email;

    @NotNull(message = "the password can't be null")
    @NotEmpty(message = "the password can't be empty")
    @NotBlank(message = "the password can't  be blank")
    @ApiModelProperty(notes = "Password of the User.",
            example = "1234", required = true)
    private String password;
    @ApiModelProperty(notes = "Photo encoded in Base64 of the User.", example = "data:image/png;base64,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")
    private String photo;

}
