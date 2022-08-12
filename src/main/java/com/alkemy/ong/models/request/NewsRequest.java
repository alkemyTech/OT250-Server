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
            example = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAcAAAAQCAIAAABV4/KnAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAENSURBVChTbclPT4JgHMDx3zs2Ix4w68QDgiyzrSYif5oiSRBYq+Es3aJQnGydOnSoDnkxolWvIFrpwbV9Tt8vFNh6hsLSQo1ma0DhLNURIy1l76+uAIpprED/VhIrP5VmVYSVXySjrmMdNks6YnUktJFobfCdNdxEgglFXu9eP55P30/jL2/6KTTHZNkGqT3oTWYVIyzu97zozbh6zmETSKxuVyxRu6waQff2xRo+IdGGvdbQj18bZ/ecGnhh4o4SotwBa/Dgxwm94xXEk4vx3L2Z5XkTJCfy7z7cKD0K5vYodcI0zztAYE3U+rutYKvqYck/OJ7kWAMQp5CcSnIyWiBKh0CzcobipCXEyd/X/Mf17tf+6AAAAABJRU5ErkJggg==",
            required = true)
    private String image;

    @ApiModelProperty(notes = "id of the category corresponding to the news to publish", example = " ")
    private Long idCategory;

}
