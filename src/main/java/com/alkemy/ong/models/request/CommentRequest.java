package com.alkemy.ong.models.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "class that represents the commentaries")
public class CommentRequest {

    @NotNull(message = "the newsID can´t be null")
    Long newsID;

    @NotNull(message = "the body can´t be null")
    @NotBlank(message = "the body can´t be blank")
    @NotEmpty(message = "the body can´t be empty")
    @ApiModelProperty( notes = "body of the category", example = "write a description of the comment", required = true)
    String body;

}
