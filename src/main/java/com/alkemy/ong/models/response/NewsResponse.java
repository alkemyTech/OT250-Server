package com.alkemy.ong.models.response;

import com.alkemy.ong.models.entity.CategoryEntity;
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
public class NewsResponse {

    private Long id;

    private String name;

    private String content;

    private String image;

    private CategoryResponse category;

    private Timestamp timestamp;

    private String type;
}
