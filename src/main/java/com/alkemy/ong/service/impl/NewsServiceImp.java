package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.models.entity.ContactEntity;
import com.alkemy.ong.models.entity.NewsEntity;
import com.alkemy.ong.models.mapper.NewsMapper;
import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.ContactResponse;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.models.response.PaginationResponse;
import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.service.NewsService;
import com.alkemy.ong.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImp implements NewsService {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsMapper newsMapper;


    @Override
    @Transactional
    public NewsResponse create(NewsRequest newsRequest) throws IOException {
        NewsEntity entity = this.newsMapper.Request2EntityCreatedNews(newsRequest);
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

    @Override
    @Transactional
    public NewsResponse update(Long id, NewsRequest newsRequest) throws IOException {

        Optional<NewsEntity> entity = this.newsRepository.findById(id);

        if (!entity.isPresent()){

            throw new NotFoundException("the id "+id+" does not belong to a news");
        }

         NewsEntity entityUpdate = this.newsMapper.EntityRefreshValues(entity.get(), newsRequest);

         NewsEntity entitySave = this.newsRepository.save(entityUpdate);

         NewsResponse response = this.newsMapper.Entity2Response(entitySave);

         return response;
    }

    @Override
    @Transactional
    public NewsResponse getById(Long id) {

       Optional<NewsEntity> entity = this.newsRepository.findById(id);

        if (!entity.isPresent()){

            throw new NotFoundException("the id "+id+" does not belong to a news");
        }

        NewsResponse response = this.newsMapper.Entity2Response(entity.get());

        return response;
    }

    @Override
    public List<NewsResponse> getAll() {
        List<NewsEntity> news = newsRepository.findAll();
        List <NewsResponse> responses = newsMapper.EntityList2Response(news);
        return responses;
    }

    @Override
    public PaginationResponse getPage(Optional<Integer> pageNumber, Optional<Integer> size) {
        PaginationUtils pagination = new PaginationUtils(newsRepository, pageNumber, size,
                                                        "/news/page=%d&size=%d");
        Page page = pagination.getPage();
        List<NewsEntity> news = page.getContent();
        List <NewsResponse> responses =     newsMapper.EntityList2Response(news);
        return PaginationResponse.builder()
                .entities(news)
                .nextPageURI(pagination.getNext())
                .prevPageURI(pagination.getPrevious())
                .build();
    }
}
