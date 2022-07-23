package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.CategoryEntity;
import com.alkemy.ong.models.response.CategoryNameResponse;
import org.springframework.stereotype.Component;

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
}
