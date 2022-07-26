package com.alkemy.ong.service;

import com.alkemy.ong.models.request.CategoryRequest;
import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.models.response.CategoryResponse;
import com.alkemy.ong.models.response.NewsResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryNameResponse> getAllCategories();
    CategoryResponse getCategoryDetails(Long id);
    void delete (Long id);
    CategoryResponse create (CategoryRequest categoryRequest);
}
