package com.alkemy.ong.models.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news")
@SQLDelete(sql= "UPDATE news SET deleted=true WHERE id=?")
@Where(clause="deleted=false")
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long id;
    @NotNull(message = "the name can´t be null")
    @NotBlank(message = "the name can´t be blank")
    @NotEmpty(message = "the name can´t be empty")
    private String name;
    @NotNull(message = "The content can´t be null")
    @Column(columnDefinition = "TEXT")
    private String content;
    @NotNull(message = "The image can´t be null")
    private String image;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @CreationTimestamp
    @Column(name = "date_update")
    private Timestamp timestamp;
    @Column(name = "soft_delete")
    private Boolean softDelete=Boolean.FALSE;
    private String type;





}