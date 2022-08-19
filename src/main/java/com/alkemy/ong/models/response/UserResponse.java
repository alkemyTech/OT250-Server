package com.alkemy.ong.models.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String token;
    private String urlPhoto;
    private String message;
}
