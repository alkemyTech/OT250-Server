package com.alkemy.ong.service;

import com.alkemy.ong.models.request.CommentRequest;
import com.alkemy.ong.models.request.CommentRequestUpDate;
import com.alkemy.ong.models.response.CommentResponse;
import com.alkemy.ong.models.response.CommentShortResponse;
import com.alkemy.ong.models.response.CommentsByNewsResponse;
import com.alkemy.ong.models.response.PaginationResponse;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    CommentResponse create(CommentRequest request, String token);

    List<CommentShortResponse> readComments();

    void delete(Long id, String token);

    List<CommentsByNewsResponse> readCommentsByNewsID(Long newsID);

    CommentResponse upDate(Long id, String token, CommentRequestUpDate request) throws Exception;

    PaginationResponse getPageCommentsByNews(Optional<Integer> page, Optional<Integer> size);



}
