package com.alkemy.ong.service;

import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.models.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryNameResponse> getAllCategories();
    CategoryResponse getCategoryDetails(Long id);
}
