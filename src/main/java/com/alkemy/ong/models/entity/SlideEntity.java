package com.alkemy.ong.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "slides")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SlideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    private String text;

    @Column(name = "ord")
    private String order;

    @Column(name = "organization_id")
    private Long organizationId;
}
