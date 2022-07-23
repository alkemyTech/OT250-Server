package com.alkemy.ong.service.impl;

import com.alkemy.ong.models.entity.CategoryEntity;
import com.alkemy.ong.models.mapper.CategoryMapper;
import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.models.response.CategoryResponse;
import com.alkemy.ong.repository.CategoryRepository;
import com.alkemy.ong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryNameResponse> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        List<CategoryNameResponse> responsesList = categoryMapper.categoryEntities2Responses(categories);
        return responsesList;
    }

    @Override
    public CategoryResponse getCategoryDetails(Long id) {

    }
}
