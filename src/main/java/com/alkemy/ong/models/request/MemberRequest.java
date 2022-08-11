package com.alkemy.ong.models.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.lang.Nullable;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "A representation of a member entity request")
public class MemberRequest {

    @NotNull(message = "the name can't be null")
    @NotEmpty
    @NotBlank(message = "the name can't be blank")
    @Pattern(regexp = "^[a-zA-Z0\s]+$", message = "The name has to contain only letters")
    @ApiModelProperty(notes = "the member name", required = true)
    private String name;

    @Nullable
    @ApiModelProperty(notes = "the facebook url", example = "facebook.com/example", required = true)
    private String facebookUrl;

    @Nullable
    @ApiModelProperty(notes = "the instagram url", example = "instagram.com/example", required = true)
    private String instagramUrl;

    @Nullable
    @ApiModelProperty(notes = "the linkedin url", example = "linkedin.com/example", required = true)
    private String linkedinUrl;

    @NotBlank
    @NotNull(message = "the image can't be null")
    @NotEmpty(message = "the image can't be empty")
    @ApiModelProperty(notes = "the member picture", example = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAcAAAAQCAIAAABV4/KnAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAENSURBVChTbclPT4JgHMDx3zs2Ix4w68QDgiyzrSYif5oiSRBYq+Es3aJQnGydOnSoDnkxolWvIFrpwbV9Tt8vFNh6hsLSQo1ma0DhLNURIy1l76+uAIpprED/VhIrP5VmVYSVXySjrmMdNks6YnUktJFobfCdNdxEgglFXu9eP55P30/jL2/6KTTHZNkGqT3oTWYVIyzu97zozbh6zmETSKxuVyxRu6waQff2xRo+IdGGvdbQj18bZ/ecGnhh4o4SotwBa/Dgxwm94xXEk4vx3L2Z5XkTJCfy7z7cKD0K5vYodcI0zztAYE3U+rutYKvqYck/OJ7kWAMQp5CcSnIyWiBKh0CzcobipCXEyd/X/Mf17tf+6AAAAABJRU5ErkJggg==",
            required = true)
    private String image;

    @Nullable
    @ApiModelProperty(notes = "the member description", example = "My name is Example and I'm 24 year olds...",
            required = true)
    private String description;
}
