package com.alkemy.ong.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Entity
@Data
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
    @Pattern(regexp = "^[a-zA-Z]+$", message = "The name has to contain only letters")
    private String name;

    @NotNull(message = "the content can't be null")
    private String content;

    @NotNull(message = "the image can't be null")
    private String image;

    @CreationTimestamp
    private Timestamp timestamp;

    @Column(name = "soft_delete")
    private boolean softDelete = false;

}

