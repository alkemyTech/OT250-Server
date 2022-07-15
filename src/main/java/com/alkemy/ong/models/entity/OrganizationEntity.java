package com.alkemy.ong.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "organizations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE organizations SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete = false")
public class OrganizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name may not be null")
    private String name;

    @NotNull(message = "Image may not be null")
    private String image;

    private String adress;

    private Integer phone;

    @NotNull(message = "Email may not be null")
    private String email;

    @Column(name = "welcome_text", columnDefinition = "TEXT")
    @NotNull(message = "Welcome text may not be null")
    private String welcomeText;

    @Column(name = "about_us_text", columnDefinition = "TEXT")
    private String aboutUsText;

    @CreatedDate
    private Timestamp timeStamp;

    @Column(name = "is_deleted")
    private boolean softDelete;

}
