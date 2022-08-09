package com.alkemy.ong.models.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "Class representing an News Request.")
public class NewsRequest {

    @NotNull(message = "the name can't be null")
    @NotBlank(message = "the name can't be blank")
    @NotEmpty(message = "the name can't be empty")
    @ApiModelProperty(notes = "Name of the news to publish",
            example = "Relatos de esfuerzo y recuperación: " +
                    "conoce nuestro hospital de cirugía reconstructiva en Amman, Jordania", required = true)
    private String name;

    @NotNull(message = "The content can't be null")
    @ApiModelProperty(notes = "Content of the news to publish",
            example = "Desde 2006, nuestro hospital especializado en servicios de cirugía reconstructiva " +
                    "en Amman, Jordania, atiende a personas de todo el Medio Oriente que no tienen acceso a la " +
                    "atención quirúrgica especializada y rehabilitación necesaria en sus países de origen.",
            required = true)
    private String content;

    @NotNull(message = "The image can't be null")
    @ApiModelProperty(notes = "Image of the news to publish",
            example = "news.jpg",
            required = true)
    private String image;

    @ApiModelProperty(notes = "id of the category corresponding to the news to publish")
    private Long idCategory;

}
