package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.ContactEntity;
import com.alkemy.ong.models.entity.NewsEntity;
import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.ContactResponse;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.repository.CategoryRepository;
import com.alkemy.ong.service.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsMapper {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AwsService awsService;

    public NewsEntity Request2Entity (NewsRequest newsRequest) throws IOException {

        NewsEntity entity = new NewsEntity();

        entity.setName(newsRequest.getName());
        entity.setContent(newsRequest.getContent());
        entity.setImage(awsService.uploadFileFromBase64(newsRequest.getImage()));
        entity.setCategory(categoryRepository.getById(newsRequest.getIdCategory()));

        return entity;

    }

    public NewsEntity Request2EntityCreatedNews (NewsRequest newsRequest) throws IOException {

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

    public NewsEntity EntityRefreshValues (NewsEntity entity, NewsRequest request) throws IOException {
        entity.setName(request.getName());
        entity.setContent(request.getContent());
        entity.setImage(awsService.uploadFileFromBase64(request.getImage()));
        entity.setCategory(categoryRepository.getById(request.getIdCategory()));
        entity.setTimestamp(new Timestamp(System.currentTimeMillis()));

      return entity;
    }

    public List<NewsResponse> EntityList2Response(List<NewsEntity> newsList){
        List<NewsResponse> responses = new ArrayList<>();
        for ( NewsEntity news: newsList){
            responses.add(Entity2Response(news));
        }

        return responses;
    }

}
