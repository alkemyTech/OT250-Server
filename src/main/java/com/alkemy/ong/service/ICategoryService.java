package com.alkemy.ong.service;

import com.alkemy.ong.models.request.CategoryRequest;
import com.alkemy.ong.models.response.*;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<CategoryNameResponse> getAllCategories();
    CategoryResponse getCategoryDetails(Long id);
    void delete (Long id);
    CategoryResponse create (CategoryRequest categoryRequest);
    CategoryResponse updateCategory(Long id, CategoryRequest category);
    PaginationResponse getCategoryPage(Optional<Integer> pageNumber, Optional<Integer> size);


}
