package com.alkemy.ong.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactResponse {

    private String name;
    private String email;
    private String message;
    private String phone;

}
