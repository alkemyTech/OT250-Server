package com.alkemy.ong.models.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import javax.validation.constraints.Pattern;


@Entity
@Builder
@Getter @Setter
@Table (name = "members")
@NoArgsConstructor @AllArgsConstructor
@SQLDelete(sql = "UPDATE members SET soft_delete = true WHERE members_id = ?")
@Where(clause = "soft_delete = false")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "members_id", updatable = false)
    private Long id;

    @Column
    @NotNull(message = "the name can't be null")
    @NotEmpty
    @NotBlank(message = "the name can't be blank")
    @Pattern(regexp = "^[a-zA-Z0\s]+$", message = "The name has to contain only letters")
    private String name;

    @Column
    @Nullable
    private String facebookUrl;

    @Column
    @Nullable
    private String instagramUrl;

    @Column
    @Nullable
    private String linkedinUrl;

    @Column
    @NotBlank
    @NotNull(message = "the image can't be null")
    @NotEmpty(message = "the image can't be empty")
    private String image;

    @Column
    @Nullable
    private String description;

    @Column (name = "time_stamp")
    @CreationTimestamp
    private Timestamp timeStamp;

    @Column (name = "soft_delete", nullable = false)
    private boolean softDelete;


}

