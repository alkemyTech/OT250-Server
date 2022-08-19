package com.alkemy.ong.models.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE categories SET soft_delete = true WHERE id = ?")
@Where(clause = "soft_delete = false")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "activities")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "activity_id")
    private Long id;

    @NotNull(message = "the name can't be null")
    private String name;

    @NotNull(message = "the content can't be null")
    private String content;

    @NotNull(message = "the image can't be null")
    private String image;

    @CreationTimestamp
    private Timestamp timestamp;

    @Column(name = "soft_delete")
    private boolean softDelete = false;

    public ActivityEntity(String name, String content, String image, Timestamp timestamp, boolean softDelete) {
        this.name = name;
        this.content = content;
        this.image = image;
        this.timestamp = timestamp;
        this.softDelete = softDelete;
    }
}

