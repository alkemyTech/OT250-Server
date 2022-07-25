package com.alkemy.ong.service;

import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.NewsResponse;

public interface NewsService {

    NewsResponse create (NewsRequest newsRequest);
    void delete (Long id);
    NewsResponse update (Long id, NewsRequest newsRequest);
    NewsResponse getById (Long id);
}
