package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.models.entity.NewsEntity;
import com.alkemy.ong.models.mapper.NewsMapper;
import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class NewsServiceImp implements NewsService {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsMapper newsMapper;


    @Override
    public NewsResponse create(NewsRequest newsRequest) {
        NewsEntity entity = this.newsMapper.Request2Entity(newsRequest);
        NewsEntity entitySave = this.newsRepository.save(entity);
        NewsResponse newsResponseCreated = this.newsMapper.Entity2Response(entitySave);

        return newsResponseCreated;
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Optional<NewsEntity> entity = this.newsRepository.findById(id);

        if (!entity.isPresent()){

            throw new NotFoundException("the id "+id+" does not belong to a news");

        }

        this.newsRepository.delete(entity.get());

    }
}
