package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.NewsEntity;
import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.NewsResponse;
import org.springframework.stereotype.Component;

@Component
public class NewsMapper {

    public NewsEntity Request2Entity (NewsRequest newsRequest){

        NewsEntity entity = new NewsEntity();

        entity.setName(newsRequest.getName());
        entity.setContent(newsRequest.getContent());
        entity.setImage(newsRequest.getImage());
        entity.setCategory(this.CategoryMapper.Request2Entity(newsRequest.getCategory()));
        entity.setType("news");

        return entity;

    }

    public NewsResponse Entity2Response (NewsEntity newsEntity){

        NewsResponse newsResponse = NewsResponse.builder()
                                    .id(newsEntity.getId())
                                    .name(newsEntity.getName())
                                    .image(newsEntity.getImage())
                                    .content(newsEntity.getContent())
                                    .category(this.CategoryMapper.Entity2Response(newsEntity.getCategory()))
                                    .timestamp(newsEntity.getTimestamp())
                                    .type(newsEntity.getType());

        return newsResponse;

    }

}
