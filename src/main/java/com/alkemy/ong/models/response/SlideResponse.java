package com.alkemy.ong.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SlideResponse {
    private Long id;
    private String imageUrl;
    private String text;
    private Integer order;
    private Long organizationId;
}
