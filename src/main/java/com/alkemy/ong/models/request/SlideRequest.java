package com.alkemy.ong.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SlideRequest {
    private String imageUrl;
    private String text;
    private Integer order;
    private Long organizationId;
}
