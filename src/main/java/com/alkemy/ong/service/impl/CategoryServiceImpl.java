package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.CategoryNotFoundException;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.models.entity.CategoryEntity;
import com.alkemy.ong.models.entity.NewsEntity;
import com.alkemy.ong.models.mapper.CategoryMapper;
import com.alkemy.ong.models.request.CategoryRequest;
import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.models.response.CategoryResponse;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.repository.CategoryRepository;
import com.alkemy.ong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        Optional<CategoryEntity> entity = categoryRepository.findById(id);
        if (!entity.isPresent())
            throw new CategoryNotFoundException("Invalid category id");
        CategoryResponse response = categoryMapper.categoryEntity2CategoryResponse(entity.get());
        return response;
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Optional<CategoryEntity> entity = this.categoryRepository.findById(id);

        if (!entity.isPresent()){

            throw new NotFoundException("the id "+id+" does not belong to a category");

        }

        this.categoryRepository.delete(entity.get());
    }

    @Override
    @Transactional
    public CategoryResponse create(CategoryRequest categoryRequest) {
        CategoryEntity entity = this.categoryMapper.Request2Entity(categoryRequest);
        CategoryEntity entitySave = this.categoryRepository.save(entity);
        CategoryResponse categoryResponseCreated = this.categoryMapper.categoryEntity2CategoryResponse(entitySave);

        return categoryResponseCreated;
    }

    public CategoryResponse updateCategory(Long id, CategoryRequest category) {
        return null;
    }


}
