package com.alkemy.ong.models.response;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {

    private String name;
    private String description;
    private String image;
    private Timestamp timestamp;

}
