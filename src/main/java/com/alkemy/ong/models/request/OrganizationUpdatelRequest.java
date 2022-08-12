package com.alkemy.ong.models.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Class representing an Organization Request for a simple update data.")
public class OrganizationUpdatelRequest {

    @ApiModelProperty(notes = "Name of the Organization",
            example = "MsF", required = true)
    private String name;

    @ApiModelProperty(notes = "Image of the organization",
            example = "medicosSinFronteras.jpg",
            required = true)
    private String image;
    private String address;
    private Integer phone;

    @ApiModelProperty(notes = "email of the organization",
            example = "medicosSinFronteras@mail.com",
            required = true)
    private String email;

    @ApiModelProperty(notes = "email of the organization",
            example = "Hi, we are Medicos sin Fronteras",
            required = true)
    private String welcomeText;
    private String aboutUsText;
    private String urlFacebook;
    private String urlInstagram;
    private String urlLinkedin;
}
