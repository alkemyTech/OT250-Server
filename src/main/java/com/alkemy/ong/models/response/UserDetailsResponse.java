package com.alkemy.ong.models.response;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class UserDetailsResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String photo;
    private Timestamp timestamp;
}
