package com.alkemy.ong.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "slides")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlideEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    private String text;

    private String order;

    @Column(name = "organization_id")
    private Long organizationId;
}
