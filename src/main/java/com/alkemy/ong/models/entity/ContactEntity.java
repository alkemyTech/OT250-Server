package com.alkemy.ong.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE contacts SET deleted_At = true WHERE id = ?")
@Where(clause = "deleted_At = false")
@Table(name = "contacts")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "contact_id")
    private Long id;

    @NotNull(message = "the name can't be null")
    private String name;

    @NotNull(message = "the phone can't be null")
    private String phone;

    @NotNull(message = "the email can't be null")
    private String email;

    @Nullable
    private String message;

    @Column(name = "deleted_At")
    private boolean deletedAt = false;

    public ContactEntity(String name, String phone, String email, @Nullable String message) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.message = message;
    }


}
