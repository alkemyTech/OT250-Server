package com.alkemy.ong.models.response;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentsByNewsResponse {
    Long id;
    String body;
    Long userID;
    Timestamp creationDate;
}
