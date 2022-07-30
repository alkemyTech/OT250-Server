package com.alkemy.ong.models.response;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestimonialResponse {

    private String name;
    private String image;
    private String content;
    private Timestamp timestamp;


}
