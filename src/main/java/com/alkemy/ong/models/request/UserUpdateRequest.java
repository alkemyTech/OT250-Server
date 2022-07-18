package com.alkemy.ong.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class UserUpdateRequest {

        @NotEmpty
        @NotBlank(message = "the first name can't be blank")
        private String firstName;

        @NotEmpty
        @NotBlank(message = "the last name can't be blank")
        private String lastName;

        @NotEmpty
        @NotBlank(message = "the password can't be blank")
        private String password;

        @NotEmpty
        @NotBlank(message = "the photo can't be blank")
        private String photo;
}
