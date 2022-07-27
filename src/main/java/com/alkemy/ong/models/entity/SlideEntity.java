package com.alkemy.ong.models.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "slides")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE users SET deleted = true Where id=?")
@Where(clause = "deleted=false")
public class SlideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    private String text;

    @Column(name = "ord")
    private Integer order;

    @Column(name = "organization_id")
    private Long organizationId;

    private Boolean deleted = Boolean.FALSE;

}