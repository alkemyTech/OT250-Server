package com.alkemy.ong.models.entity;

import com.amazonaws.services.dynamodbv2.xspec.S;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name= "users")
@SQLDelete(sql = "UPDATE users SET deleted = true Where id=?")
@Where(clause = "deleted=false")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty(message = "The first name can't be null")
    @NotBlank(message = "The first name can't be blank")
    @Column( name = "first_name", nullable = false)
    private String firstName;

    @NonNull
    @NotEmpty(message = "The last name can't be null")
    @NotBlank(message = "The last name can't be blank")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Email(message = "the email can't be null")
    @Column(unique = true, nullable = false)
    private String email;

    private String photo;

    @NotNull
    @NotEmpty(message = "The Password can't be null")
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<RoleEntity> roleId;

    private Timestamp timestamp;

    private Boolean deleted = Boolean.FALSE;

    public UserEntity(String firstName, String lastName, String email, String password, Set<RoleEntity> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roles;
    }

}
