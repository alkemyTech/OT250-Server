package com.alkemy.ong.service.impl;

import com.alkemy.ong.models.entity.CommentEntity;
import com.alkemy.ong.models.mapper.CommentMapper;
import com.alkemy.ong.models.request.CommentRequest;
import com.alkemy.ong.models.response.CommentResponse;
import com.alkemy.ong.repository.CommentRepository;
import com.alkemy.ong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentRepository commentRepository;

    public CommentResponse create(CommentRequest request) {
        CommentEntity commentEntity = commentMapper.toEntity(request);
        commentEntity = commentRepository.save(commentEntity);
        return commentMapper.toResponse(commentEntity);
    }

}
