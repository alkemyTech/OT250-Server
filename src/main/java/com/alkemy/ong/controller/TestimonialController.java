package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.TestimonialRequest;
import com.alkemy.ong.models.response.PaginationResponse;
import com.alkemy.ong.models.response.TestimonialResponse;
import com.alkemy.ong.models.response.UsersPaginationResponse;
import com.alkemy.ong.service.TestimonialService;
import com.alkemy.ong.service.impl.TestimonialServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/testimonials")
@Api(description ="Testimonial CRUD" , tags = "Testimonials")
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    @Autowired
    private TestimonialServiceImpl testimonialServiceImpl;

    @Transactional
    @PostMapping
    @ApiOperation(value = "Create Testimonial", notes = "Allow Users and Admin to insert a new testimonial")
    @ApiResponses(value = {
            @ApiResponse( code = 201, message = "Testimonial created"),
            @ApiResponse( code = 400, message = "bad request"),
            @ApiResponse( code = 403, message = "forbidden")
    })
    public ResponseEntity<TestimonialResponse> create(@Valid @RequestBody TestimonialRequest request) throws IOException {

        TestimonialResponse response = testimonialService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @Transactional
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Testimonial", notes = "Allow Users and Admin to update an existing testimonial using its id")
    @ApiResponses(value = {
            @ApiResponse( code = 201, message = "Testimonial Updated"),
            @ApiResponse( code = 400, message = "bad request"),
            @ApiResponse( code = 403, message = "forbidden")
    })
    public ResponseEntity<TestimonialResponse> upDate(@Valid @RequestBody TestimonialRequest request,
                                                      @PathVariable Long id ){

        TestimonialResponse response = testimonialService.upDate(request, id);

        return ResponseEntity.ok(response);

    }

    @Transactional
    @DeleteMapping("/{id}")
    @PutMapping("/{id}")
    @ApiOperation(value = "Delete Testimonial", notes = "Allow Users and Admin to delete an existing testimonial using its id")
    @ApiResponses(value = {
            @ApiResponse( code = 201, message = "Testimonial deleted"),
            @ApiResponse( code = 403, message = "forbidden")
    })
    public ResponseEntity<TestimonialResponse> delete(@Valid @PathVariable Long id ){

        TestimonialResponse response = testimonialService.delete(id);

        return ResponseEntity.ok(response);

    }

    @GetMapping
    @ApiOperation(value = "List all the testimonials", notes = "Allows users and admins to List all the testimonials")
    @ApiResponses(value = {
            @ApiResponse( code = 201, message = "testimonial's list"),
            @ApiResponse( code = 403, message = "forbidden")
    })
    public ResponseEntity<?> getAll(@RequestParam(value = "page", required = false) Optional<Integer> page,
                                    @RequestParam(value = "size", required = false) Optional<Integer> size) throws IOException {
        PaginationResponse response = testimonialService.getPage(page,size);
        return ResponseEntity.ok().body(response);

    }

}
