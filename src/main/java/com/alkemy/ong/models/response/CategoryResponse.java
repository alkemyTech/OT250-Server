package com.alkemy.ong.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

    private String name;
    private String description;
    private String image;
    private Timestamp timestamp;

}
