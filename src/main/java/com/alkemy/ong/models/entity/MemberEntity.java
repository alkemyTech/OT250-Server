package com.alkemy.ong.models.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.security.Timestamp;


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
    @NotNull
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
    @NotNull
    private String image;

    @Column
    @Nullable
    private String description;

    @Column (name = "soft_delete", nullable = false)
    private boolean softDelete;

    @CreationTimestamp
    @Column (name = "time_stamp" ,nullable = false, updatable = false)
    private Timestamp timeStamp;
}

