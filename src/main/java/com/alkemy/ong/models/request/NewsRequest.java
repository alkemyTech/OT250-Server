package com.alkemy.ong.models.request;

import com.alkemy.ong.models.entity.CategoryEntity;
import com.alkemy.ong.models.response.CategoryResponse;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsRequest {

    @NotNull(message = "the name can´t be null")
    @NotBlank(message = "the name can´t be blank")
    @NotEmpty(message = "the name can´t be empty")
    private String name;
    @NotNull(message = "The content can´t be null")
    private String content;
    @NotNull(message = "The image can´t be null")
    private String image;

    private Long idCategory;

    //private CategoryRequest category;



}
