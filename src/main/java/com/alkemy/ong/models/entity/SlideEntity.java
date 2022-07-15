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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    private String text;

    private String order;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = OrganizationEntity.class)
    @JoinTable(
            name = "slides_organization",
            joinColumns = @JoinColumn(name = "slide_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id")
    )
    private OrganizationEntity organization;
}
