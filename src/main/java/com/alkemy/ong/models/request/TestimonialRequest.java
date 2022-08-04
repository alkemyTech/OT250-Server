package com.alkemy.ong.models.request;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class TestimonialRequest {

    @NotBlank(message = "the image can't be blank")
    @NotNull(message = "the image can't be null")
    @NotEmpty(message = "the image can't be empty")
    private String name;

    @NotBlank(message = "the image can't be blank")
    @NotNull(message = "the image can't be null")
    @NotEmpty(message = "the image can't be empty")
    private String image;

    @Column
    @Nullable
    private String content;

    private Timestamp timestamp;


}
