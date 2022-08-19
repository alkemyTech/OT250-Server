package com.alkemy.ong.models.request;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "class that represents the category")
public class CategoryRequest {

    @NotNull(message =  "the name can't be null")
    @NotEmpty(message = "the name can't be empty")
    @NotBlank(message = "the name can't be blank")
    @Pattern(regexp = "^[a-zA-Z0\s]+$", message = "The name has to contain only letters and spaces")
    @ApiModelProperty( notes = "name of the category", example = "category-1", required = true)
    private String name;

    @Nullable
    @ApiModelProperty( notes = "description of the category", example = "names descriptions of the category")
    private String description;

    @Nullable
    @ApiModelProperty( notes = "name of the category", example = "cat.jpg")
    private String image;

}
