package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.CategoryNotFoundException;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.models.entity.CategoryEntity;
import com.alkemy.ong.models.entity.ContactEntity;
import com.alkemy.ong.models.entity.NewsEntity;
import com.alkemy.ong.models.mapper.CategoryMapper;
import com.alkemy.ong.models.request.CategoryRequest;
import com.alkemy.ong.models.response.*;
import com.alkemy.ong.repository.CategoryRepository;
import com.alkemy.ong.service.ICategoryService;
import com.alkemy.ong.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public CategoryResponse getCategoryDetails(Long id) {
        Optional<CategoryEntity> entity = categoryRepository.findById(id);
        if (!entity.isPresent())
            throw new CategoryNotFoundException("Invalid category id");
        CategoryResponse response = categoryMapper.categoryEntity2CategoryResponse(entity.get());
        return response;
    }

    @Transactional
    public void delete(Long id) {
        Optional<CategoryEntity> entity = this.categoryRepository.findById(id);
        if (!entity.isPresent())
            throw new CategoryNotFoundException("the id "+id+" does not belong to a category");
        this.categoryRepository.delete(entity.get());
    }

    public CategoryResponse create(CategoryRequest categoryRequest) {
        CategoryEntity entity = this.categoryMapper.Request2Entity(categoryRequest);
        CategoryEntity entitySave = this.categoryRepository.save(entity);
        CategoryResponse categoryResponseCreated = this.categoryMapper.categoryEntity2CategoryResponse(entitySave);
        return categoryResponseCreated;
    }


    public CategoryResponse updateCategory(Long id, CategoryRequest category) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        CategoryEntity updatedCategory = categoryMapper.updateCategoryEntityFromRequest(categoryEntity, category);
        return categoryMapper.categoryEntity2CategoryResponse(categoryRepository.save(updatedCategory));
    }

    @Override
    public PaginationResponse getCategoryPage(Optional<Integer> pageNumber, Optional<Integer> size) {
        PaginationUtils pagination = new PaginationUtils(categoryRepository, pageNumber, size, "/categories/page=%d&size=%d");
        Page page = pagination.getPage();

        List<CategoryEntity> categories = page.getContent();
        List <CategoryResponse> responses = categoryMapper.CategoryListToResponses(categories);

        return PaginationResponse.builder()
                .entities(categories)
                .nextPageURI(pagination.getNext())
                .prevPageURI(pagination.getPrevious())
                .build();
    }



}
