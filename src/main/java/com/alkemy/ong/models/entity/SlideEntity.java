package com.alkemy.ong.models.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "slides")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE slides SET deleted = true Where id=?")
@Where(clause = "deleted=false")
public class SlideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "image_url")
    private String imageUrl;

    @NotNull
    @NotEmpty
    private String text;

    @Column(name = "ord")
    private Integer order;

    @NotNull
    @Column(name = "organization_id")
    private Long organizationId;

    private Boolean deleted = Boolean.FALSE;

    public SlideEntity(String imageUrl, String text, Integer order, Long organizationId) {
        this.imageUrl = imageUrl;
        this.text = text;
        this.order = order;
        this.organizationId = organizationId;
    }

}