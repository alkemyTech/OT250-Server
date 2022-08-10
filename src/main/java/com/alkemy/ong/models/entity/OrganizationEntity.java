package com.alkemy.ong.models.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@SQLDelete(sql= "UPDATE organizations SET soft_delete = true WHERE organization_id=?")
@Where(clause = "soft_delete=false")
@Table(name = "organizations")
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Data
public class OrganizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private Long id;

    @NonNull
    @NotEmpty(message = "name can not be null")
    @NotBlank(message = "name can not be blank")
    @Column(nullable = false)
    private String name;

    @NonNull
    @NotEmpty(message = "image can not be null")
    @Column(nullable = false)
    private String image;

    private String address;

    private Integer phone;

    @NonNull
    @NotEmpty(message = "email can not be null")
    @Email(message = "mail is not valid")
    @Column(nullable = false)
    private String email;

    @NonNull
    @NotEmpty(message = "welcomeText can not be null")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String welcomeText;

    @Column(columnDefinition = "TEXT")
    private String aboutUsText;

    @Column(name = "soft_delete")
    @Builder.Default
    private boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    private Timestamp timestamp;

    private String urlFacebook;

    private String urlInstagram;

    private String urlLinkedin;

    public OrganizationEntity(String name, String image, String email, String welcomeText, Timestamp timestamp) {
        this.name = name;
        this.image = image;
        this.email = email;
        this.welcomeText = welcomeText;
        this.timestamp = timestamp;
    }
}
