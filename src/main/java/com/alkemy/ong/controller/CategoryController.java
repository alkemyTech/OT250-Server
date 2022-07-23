package com.alkemy.ong.controller;

import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryNameResponse>> getAllCategories() {
        List<CategoryNameResponse> categories = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }
}
