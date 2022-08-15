package com.alkemy.ong.service;

import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.ContactResponse;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.models.response.PaginationResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NewsService {

    NewsResponse create (NewsRequest newsRequest) throws IOException;
    void delete (Long id);
    NewsResponse update (Long id, NewsRequest newsRequest) throws IOException;
    NewsResponse getById (Long id);

    List<NewsResponse> getAll();

    PaginationResponse getPage(Optional<Integer> page, Optional<Integer> size);
}
