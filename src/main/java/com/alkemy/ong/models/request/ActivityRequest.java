package com.alkemy.ong.models.request;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class ActivityRequest {

    @NotNull(message = "the name can't be null")
    @NotBlank(message = "the name can't be blank")
    @NotEmpty(message = "the name can't be empty")
    private String name;

    @NotNull(message = "the name can't be null")
    @NotBlank(message = "the name can't be blank")
    @NotEmpty(message = "the name can't be empty")
    private String content;

    @NotNull(message = "the name can't be null")
    @NotBlank(message = "the name can't be blank")
    @NotEmpty(message = "the name can't be empty")
    private String image;

    @CreationTimestamp
    private Timestamp timestamp;


}
