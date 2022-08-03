package com.alkemy.ong.service.impl;

import com.alkemy.ong.auth.utility.JwtUtils;
import com.alkemy.ong.exception.BodyIsNullException;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.models.entity.CommentEntity;
import com.alkemy.ong.models.entity.RoleEntity;
import com.alkemy.ong.models.entity.UserEntity;
import com.alkemy.ong.models.mapper.CommentMapper;
import com.alkemy.ong.models.request.CommentRequest;
import com.alkemy.ong.models.request.CommentRequestUpDate;
import com.alkemy.ong.models.response.CommentResponse;
import com.alkemy.ong.models.response.CommentShortResponse;
import com.alkemy.ong.repository.CommentRepository;
import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.service.CommentService;
import com.amazonaws.services.pinpoint.model.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsRepository newsRepository;

    public CommentResponse create(CommentRequest request) {
        CommentEntity commentEntity = commentMapper.toEntity(request);
        commentEntity = commentRepository.save(commentEntity);
        return commentMapper.toResponse(commentEntity);
    }

    public List<CommentShortResponse> readComments() {
        List<CommentEntity> entities = commentRepository.findAllByTimestampAsc();
        List<CommentShortResponse>  responses = commentMapper.toShortResponseList(entities);
        return responses;
    }

    public void delete(Long id, String token) {
        if (! commentRepository.existsById(id)){
            throw new NotFoundException("Comment (id = "+id+") not found");
        }
        token = token.substring(7);
        String username = jwtUtils.extractUsername(token);
        UserEntity userEntity = userRepository.findByEmail(username).get();
        Set<RoleEntity> roleEntities = userEntity.getRoleId();
        List<String> roles = roleEntities.stream().map(RoleEntity::getName).collect(Collectors.toList());
        if (roleEntities.contains("ADMIN")) {
            commentRepository.deleteById(id);
        }
        else {
            CommentEntity commentEntity = commentRepository.getById(id);
            if (commentEntity.getUser() != userEntity) {
                throw new ForbiddenException("Not authorized");
            }
            commentRepository.deleteById(id);
        }
    }

    public List<CommentShortResponse> readCommentsByNewsID(Long newsID) {
        List<CommentEntity> commentEntities = commentRepository.findCommentsByNewsID(newsID);
        return commentMapper.toShortResponseList(commentEntities);
    }

    @Override
    public CommentResponse upDate(Long id, String token, CommentRequestUpDate request) throws Exception {

        if (! commentRepository.existsById(id)){
            throw new NotFoundException("Comment (id = "+id+") not found");
        }

        token = token.substring(7);
        String username = jwtUtils.extractUsername(token);
        UserEntity entityLogin = userRepository.findByEmail(username).get();

        Set<RoleEntity> roleEntities = entityLogin.getRoleId();
        List<String> roles = roleEntities.stream().map(RoleEntity::getName).collect(Collectors.toList());

        CommentEntity entityFound = commentRepository.getById(id);

        if (roleEntities.contains("ADMIN")) {
            throw new ForbiddenException("ADMIN NOT AUTHORIZED");
        }
        else {
            if (entityFound.getUser() != entityLogin) {
                throw new ForbiddenException("NOT AUTHORIZED");
            }

            if(request.getBody().isBlank() || request.getBody().isEmpty() || request.getBody() ==null){
                throw new BodyIsNullException("BODY IS NULL OR EMPTY");
            }
            else{
                entityFound.setBody(request.getBody());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                entityFound.setTimestamp(timestamp);
            }
        }

        CommentResponse response = new CommentResponse();
        commentRepository.save(entityFound);
        response = commentMapper.toResponse(entityFound);

        return response;

    }

}
