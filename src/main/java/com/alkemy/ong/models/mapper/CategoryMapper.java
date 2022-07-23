package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.CategoryEntity;
import com.alkemy.ong.models.response.CategoryNameResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryNameResponse category2CategoryNameResponse(CategoryEntity categoryEntity) {
        return CategoryNameResponse.builder()
                .name(categoryEntity.getName())
                .build();
    }


}
