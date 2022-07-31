package com.alkemy.ong.service;

import com.alkemy.ong.models.request.CommentRequest;
import com.alkemy.ong.models.response.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentResponse create(CommentRequest request);

}
