package com.alkemy.ong.models.request;

import lombok.*;
import org.springframework.lang.Nullable;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberRequest {


    @NotNull(message = "the name can't be null")
    @NotEmpty
    @NotBlank(message = "the name can't be blank")
    private String name;


    @Nullable
    private String facebookUrl;


    @Nullable
    private String instagramUrl;


    @Nullable
    private String linkedinUrl;


    @NotBlank
    @NotNull(message = "the image can't be null")
    @NotEmpty(message = "the image can't be empty")
    private String image;


    @Nullable
    private String description;
}
