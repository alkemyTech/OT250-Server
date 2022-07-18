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
import java.sql.Timestamp;


@Entity
@Builder
@Getter @Setter
@Table (name = "testimonials")
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE testimonials SET soft_delete = true WHERE testimonial_id = ?")
@Where(clause = "soft_delete = false")
public class TestimonialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testimonial_id")
    private Long id;

    @NotNull(message = "the name can't be null")
    @NotEmpty(message = "the name can't be empty")
    private String name;

    @NotBlank
    @NotNull(message = "the image can't be null")
    @NotEmpty(message = "the image can't be empty")
    private String image;

    @Column
    @Nullable
    private String content;

    @Column(name = "timeStamp")
    @CreationTimestamp
    private Timestamp timestamp;

    @Column (name = "soft_delete", nullable = false)
    private boolean softDelete;
}

