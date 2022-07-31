package com.alkemy.ong.service;

import com.alkemy.ong.models.request.CommentRequest;
import com.alkemy.ong.models.response.CommentResponse;
import com.alkemy.ong.models.response.CommentShortResponse;

import java.util.List;

public interface CommentService {
    CommentResponse create(CommentRequest request);

    List<CommentShortResponse> readComments();

    void delete(Long id, String token);

    List<CommentShortResponse> readCommentsByNewsID(Long newsID);

}
