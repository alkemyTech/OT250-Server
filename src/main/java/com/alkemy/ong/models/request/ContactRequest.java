package com.alkemy.ong.models.request;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@Data
public class ContactRequest {

    @NotNull(message = "the name can't be null")
    private String name;

    @NotNull(message = "the phone can't be null")
    private String phone;

    @NotNull(message = "the email can't be null")
    private String email;

    @Nullable
    private String message;
}
