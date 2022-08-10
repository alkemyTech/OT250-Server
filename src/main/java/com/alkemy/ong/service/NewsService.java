package com.alkemy.ong.service;

import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.NewsResponse;

import java.io.IOException;

public interface NewsService {

    NewsResponse create (NewsRequest newsRequest) throws IOException;
    void delete (Long id);
    NewsResponse update (Long id, NewsRequest newsRequest) throws IOException;
    NewsResponse getById (Long id);
}
