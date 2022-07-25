package com.alkemy.ong.models.request;

import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsRequest {

    @NotNull(message = "the name can't be null")
    @NotBlank(message = "the name can't be blank")
    @NotEmpty(message = "the name can't be empty")
    private String name;
    @NotNull(message = "The content can't be null")
    private String content;
    @NotNull(message = "The image can't be null")
    private String image;

    private Long idCategory;
    //private CategoryRequest category;
}
