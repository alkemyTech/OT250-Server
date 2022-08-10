package com.alkemy.ong.models.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Class representing an Organization Request.")
public class OrganizationRequest {
    
    @NonNull
    @NotEmpty(message = "the first name can't be null")
    @NotBlank(message = "the first name can't  be blank")
    @ApiModelProperty(notes = "Name of the Organization",
            example = "Medicos sin Fronteras", required = true)
    private String name;

    @NonNull
    @NotEmpty(message = "the image can't be null")
    @NotBlank(message = "the image can't  be blank")
    @ApiModelProperty(notes = "Image of the organization",
            example = "data:image/jpeg;base64",
            required = true)
    private String image;

    @ApiModelProperty(notes = "Address of the organization",
            example = "Buenos Aires",
            required = true)
    private String address;

    @ApiModelProperty(notes = "Address of the organization",
            example = "235671889",
            required = true)
    private Integer phone;

    @NonNull
    @NotEmpty(message = "the email can't be null")
    @NotBlank(message = "the email can't  be blank")
    @ApiModelProperty(notes = "email of the organization",
            example = "medicosSinFronteras@mail.com",
            required = true)
    private String email;

    @NonNull
    @NotEmpty(message = "the welcome text can't be null")
    @NotBlank(message = "the welcome text can't  be blank")
    @ApiModelProperty(notes = "email of the organization",
            example = "Hi, we are Medicos sin Fronteras",
            required = true)
    private String welcomeText;

    @ApiModelProperty(notes = "description of the organization",
            example = "Médicos Sin Fronteras (MSF) es una organización de acción médico-humanitaria: " +
                    "asistimos a personas amenazadas por conflictos armados, violencia, epidemias o" +
                    " enfermedades olvidadas, desastres naturales y exclusión de la atención médica.",
            required = true)
    private String aboutUsText;

    @ApiModelProperty(notes = "Facebook of the organization",
            example = "msf.facebook.com",
            required = true)
    private String urlFacebook;

    @ApiModelProperty(notes = "Instagram of the organization",
            example = "msf.instagram.com",
            required = true)
    private String urlInstagram;

    @ApiModelProperty(notes = "LinkedIn of the organization",
            example = "msf.LinkedIn.com",
            required = true)
    private String urlLinkedin;
}
