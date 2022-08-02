package com.alkemy.ong.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestUpDate {
    @NotNull(message = "the body can´t be null")
    @NotBlank(message = "the body can´t be blank")
    @NotEmpty(message = "the body can´t be empty")
    String body;

}
