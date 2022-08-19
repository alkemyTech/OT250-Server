package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.CategoryEntity;
import com.alkemy.ong.models.request.CategoryRequest;
import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.models.response.CategoryResponse;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public CategoryNameResponse category2CategoryNameResponse(CategoryEntity categoryEntity) {
        return CategoryNameResponse.builder()
                .name(categoryEntity.getName())
                .build();
    }

    public List<CategoryNameResponse> categoryEntities2Responses(List<CategoryEntity> categoryEntities) {
        List<CategoryNameResponse> nameResponseList = categoryEntities.stream()
                .map(c -> category2CategoryNameResponse(c)).collect(Collectors.toList());
        return nameResponseList;
    }

    public CategoryResponse categoryEntity2CategoryResponse(CategoryEntity categoryEntity) {
        return CategoryResponse.builder().name(categoryEntity.getName())
                .description(categoryEntity.getDescription())
                .image(categoryEntity.getImage())
                .timestamp(categoryEntity.getTimestamp())
                .build();
    }

    public CategoryEntity Request2Entity (CategoryRequest categoryRequest){

       return CategoryEntity.builder().name(categoryRequest.getName())
                .description(categoryRequest.getDescription())
                .image(categoryRequest.getImage())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();

    }

    public CategoryEntity updateCategoryEntityFromRequest(CategoryEntity updatedCategory, CategoryRequest category) {
        updatedCategory.setName(category.getName());
        updatedCategory.setDescription(category.getDescription());
        updatedCategory.setImage(category.getImage());
        updatedCategory.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return updatedCategory;
    }

    public List<CategoryResponse> CategoryListToResponses(List<CategoryEntity> categories){
        List<CategoryResponse> responses = new ArrayList<>();

        for ( CategoryEntity category: categories){
            responses.add(categoryEntity2CategoryResponse(category));
        }

        return responses;
    }

}
