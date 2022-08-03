package com.alkemy.ong.models.mapper;

import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.models.entity.CommentEntity;
import com.alkemy.ong.models.entity.NewsEntity;
import com.alkemy.ong.models.entity.UserEntity;
import com.alkemy.ong.models.request.CommentRequest;
import com.alkemy.ong.models.response.CommentResponse;
import com.alkemy.ong.models.response.CommentShortResponse;
import com.alkemy.ong.models.response.CommentsByNewsResponse;
import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.repository.UserRepository;
import com.amazonaws.services.simplesystemsmanagement.model.ParameterAlreadyExistsException;
import com.amazonaws.services.simplesystemsmanagement.model.ParameterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CommentMapper {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private UserRepository userRepository;

    public CommentEntity toEntity(CommentRequest request, Long userID) {
        Optional<NewsEntity> newsEntity = newsRepository.findById(request.getNewsID());
        if (newsEntity.isEmpty()) {
            throw new NotFoundException("news (id = "+request.getNewsID()+") not found");
        }
        Optional<UserEntity> userEntity = userRepository.findById(userID);
        if (userEntity.isEmpty()) {
            throw new NotFoundException("user (id = "+userID+") not found");
        }
        return CommentEntity.builder()
                .body(request.getBody())
                .user(userEntity.get())
                .news(newsEntity.get())
                .build();
    }

    public CommentResponse toResponse(CommentEntity entity) {
        return CommentResponse.builder()
                .id(entity.getId())
                .body(entity.getBody())
                .newsID(entity.getNews().getId())
                .userID(entity.getUser().getId())
                .creationDate(entity.getTimestamp())
                .build();
    }

    public CommentShortResponse toShortResponse(CommentEntity entity) {
        return CommentShortResponse.builder()
                .body(entity.getBody())
                .build();
    }

    public List<CommentShortResponse> toShortResponseList(List<CommentEntity> entities) {
        List<CommentShortResponse> responseList = new ArrayList<>();
        for (CommentEntity entity : entities) {
            responseList.add(toShortResponse(entity));
        }
        return responseList;
    }

    public CommentsByNewsResponse toCommentsByNewsResponse(CommentEntity entity) {
        return CommentsByNewsResponse.builder()
                .id(entity.getId())
                .body(entity.getBody())
                .userID(entity.getUser().getId())
                .creationDate(entity.getTimestamp())
                .build();
    }

    public List<CommentsByNewsResponse> toCommentsByNewsResponseList(List<CommentEntity> entities) {
        List<CommentsByNewsResponse> responseList = new ArrayList<>();
        for (CommentEntity entity : entities) {
            responseList.add(toCommentsByNewsResponse(entity));
        }
        return responseList;
    }
}
