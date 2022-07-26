package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.CategoryRequest;
import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.models.response.CategoryResponse;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getDetailsById(@PathVariable Long id) {
        CategoryResponse response = categoryService.getCategoryDetails(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory (@PathVariable Long id){

        this.categoryService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory (@RequestBody CategoryRequest categoryRequest){

        CategoryResponse categoryResponseCreate = categoryService.create(categoryRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponseCreate);
    }
}
