package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.CategoryEntity;
import com.alkemy.ong.models.entity.NewsEntity;
import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class NewsMapper {
    @Autowired
    CategoryRepository categoryRepository;

    public NewsEntity Request2Entity (NewsRequest newsRequest){

        NewsEntity entity = new NewsEntity();

        entity.setName(newsRequest.getName());
        entity.setContent(newsRequest.getContent());
        entity.setImage(newsRequest.getImage());
        entity.setCategory(categoryRepository.getById(newsRequest.getIdCategory()));

        return entity;

    }

    public NewsEntity Request2EntityCreatedNews (NewsRequest newsRequest){

        NewsEntity entity = this.Request2Entity(newsRequest);
        entity.setType("news");

        return entity;

    }

    public NewsResponse Entity2Response (NewsEntity newsEntity){

        NewsResponse newsResponse = NewsResponse.builder()
                                    .id(newsEntity.getId())
                                    .name(newsEntity.getName())
                                    .image(newsEntity.getImage())
                                    .content(newsEntity.getContent())
                                    .idCategory(newsEntity.getCategory().getId())
                                    .timestamp(newsEntity.getTimestamp())
                                    .type(newsEntity.getType()).build();

        return newsResponse;

    }

    public NewsEntity EntityRefreshValues (NewsEntity entity, NewsRequest request){
        entity.setName(request.getName());
        entity.setContent(request.getContent());
        entity.setImage(request.getImage());
        entity.setCategory(categoryRepository.getById(request.getIdCategory()));
        entity.setTimestamp(new Timestamp(System.currentTimeMillis()));

      return entity;
    }

}
