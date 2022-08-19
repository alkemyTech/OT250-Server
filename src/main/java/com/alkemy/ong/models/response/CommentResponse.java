package com.alkemy.ong.models.response;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResponse {
    Long id;
    String body;
    Long newsID;
    Long userID;
    Timestamp creationDate;
}
