package com.alkemy.ong.models.response;

import lombok.*;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResponse {

    private String name;

    private String facebookUrl;

    private String instagramUrl;

    private String linkedinUrl;

    private String image;

    private String description;

    private Timestamp timeStamp;
}
