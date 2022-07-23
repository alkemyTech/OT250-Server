package com.alkemy.ong.service;

import com.alkemy.ong.models.response.CategoryNameResponse;

import java.util.List;

public interface ICategoryService {

    List<CategoryNameResponse> getAllCategories();
}
