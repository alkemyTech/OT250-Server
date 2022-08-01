package com.alkemy.ong.models.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationPartialRequest {
    

    private String name;
    private String image;
    private String address;
    private Integer phone;
    private String email;
    private String welcomeText;
    private String aboutUsText;
    private String urlFacebook;
    private String urlInstagram;
    private String urlLinkedin;
}
