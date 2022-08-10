package com.alkemy.ong.models.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "Class representing a Contact Request.")
public class ContactRequest {

    @NotNull(message = "the name can't be null")
    @NotBlank(message = "the name can't be blank")
    @NotEmpty(message = "the name can't be empty")
    @ApiModelProperty(notes = "Contact's name",
                    example = "Ezekiel King", required = true)
    private String name;

    @NotNull(message = "the name can't be null")
    @NotBlank(message = "the name can't be blank")
    @NotEmpty(message = "the name can't be empty")
    @ApiModelProperty(notes = "Contact's phone number",
            example = "+99 9 9999 999999", required = true)
    private String phone;

    @NotNull(message = "the name can't be null")
    @NotBlank(message = "the name can't be blank")
    @NotEmpty(message = "the name can't be empty")
    @ApiModelProperty(notes = "Contact's email",
            example = "ezequiel.king@mail.com", required = true)
    private String email;

    @Nullable
    @ApiModelProperty(notes = "Contact's message",
            example = "Old friend from high school")
    private String message;
}
