package com.alkemy.ong.models.request;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class ActivityRequest {

    @NotNull(message = "the name can't be null")
    private String name;

    @NotNull(message = "the content can't be null")
    private String content;

    @NotNull(message = "the image can't be null")
    private String image;

    @CreationTimestamp
    private Timestamp timestamp;


}
