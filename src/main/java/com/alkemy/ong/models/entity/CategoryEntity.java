package com.alkemy.ong.models.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE categories SET soft_delete = true WHERE category_id = ?")
@Where(clause = "soft_delete = false")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Builder
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "category_id")
    private Long id;

    @NotNull
    @NotEmpty(message = "the name can't be null")
    @NotBlank(message = "the name can't be blank")
    @Pattern(regexp = "^[a-zA-Z0\s]+$", message = "The name has to contain only letters")
    private String name;

    @Nullable
    private String description;

    @Nullable
    private String image;

    @CreationTimestamp
    @Column(name = "time_stamp")
    private Timestamp timestamp;

    @Column(name = "soft_delete")
    private boolean softDelete = false;


    public CategoryEntity(String name, String description, String img, Timestamp timestamp, boolean softDelete) {
        this.name = name;
        this.description = description;
        this.image = img;
        this.timestamp = timestamp;
        this.softDelete = softDelete;
    }
}
