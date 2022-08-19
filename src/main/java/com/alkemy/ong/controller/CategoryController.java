package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.CategoryRequest;
import com.alkemy.ong.models.response.*;
import com.alkemy.ong.service.ICategoryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@Api(description = "This API has a CRUD for Category", tags = "Category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Details by Category ", notes = "Get Details a category by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Found Category"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Category required by id Not Found"),})
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getDetailsById(@Valid @PathVariable @NotNull @NotBlank @ApiParam(
                                                                                        name = "id",
                                                                                        type = "Long",
                                                                                        value = "ID of the category",
                                                                                        example = "1",
                                                                                        required = true ) Long id ) {
        CategoryResponse response = categoryService.getCategoryDetails(id);
        return ResponseEntity.ok(response);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete category ", notes = "Delete a category by ID")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Deleted Category"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Category required by id Not Found"),})
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory (@Valid @PathVariable @NotNull @NotBlank @ApiParam(
                                                                                name = "id",
                                                                                type = "Long",
                                                                                value = "ID of the category",
                                                                                example = "1",
                                                                                required = true ) Long id ) {

        this.categoryService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create category ", notes = "create a category with the requests")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Category created!"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Category required by id Not Found"),})
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory (@Valid @RequestBody @ApiParam(
                                                                                    name = "new name category",
                                                                                    value = "category to save",
                                                                                    required = true)
                                                                                    CategoryRequest categoryRequest ){

        CategoryResponse categoryResponseCreate = categoryService.create(categoryRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponseCreate);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Update category by ID", notes = "Allows the user to update existing categories by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Category updated!"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Category required by id Not Found"),})
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@Valid @PathVariable @NotNull @NotBlank @ApiParam(
                                                                                    name = "id",
                                                                                    type = "Long",
                                                                                    value = "ID of the category",
                                                                                    example = "1",
                                                                                    required = true ) Long id,
                                                           @RequestBody  @ApiParam(
                                                                                    name = "new name category",
                                                                                    value = "category to save",
                                                                                    required = true)
                                                                                    CategoryRequest category
                                                                                                            ){

        return new ResponseEntity<>(categoryService.updateCategory(id, category), HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get All Categories by Page ", notes = "Get All a category")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Founds Categories"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Category required by id Not Found"),})
    @GetMapping
    public ResponseEntity<PaginationResponse> getCategoryAll(@RequestParam(value = "page", required = false) Optional<Integer> page,
                                    @RequestParam(value = "size", required = false) Optional<Integer> size) {

            PaginationResponse responses = categoryService.getCategoryPage(page, size);
            return new ResponseEntity<>(responses, HttpStatus.OK);

    }


}
