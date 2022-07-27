package com.alkemy.ong.models.response;


import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsResponse {

    private Long id;

    private String name;

    private String content;

    private String image;

    private Long idCategory;

    private Timestamp timestamp;

    private String type;
}
