package com.alkemy.ong.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
