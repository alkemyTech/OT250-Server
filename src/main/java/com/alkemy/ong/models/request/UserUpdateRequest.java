package com.alkemy.ong.models.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public class UserUpdateRequest {

        @ApiModelProperty(notes = "Name of the user",
                example = "Larry",
                required = true)
        private String firstName;

        @ApiModelProperty(notes = "Last name of the user",
                example = "Black",
                required = true)
        private String lastName;

        @ApiModelProperty(notes = "User new password",
                example = "123456",
                required = true)
        private String password;

        @ApiModelProperty(notes = "User new photo",
                example = "data:image/jpeg;base64",
                required = true)
        private String photo;
}
