package com.alkemy.ong.models.request;



import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

    private String name;
    private String description;
    private String image;

}
