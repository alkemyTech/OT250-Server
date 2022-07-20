package com.alkemy.ong.models.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public class UserUpdateRequest {

        private String firstName;


        private String lastName;


        private String password;


        private String photo;
}
