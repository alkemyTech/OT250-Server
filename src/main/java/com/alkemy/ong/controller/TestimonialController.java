package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.TestimonialRequest;
import com.alkemy.ong.models.response.TestimonialResponse;
import com.alkemy.ong.service.TestimonialService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/testimonials")
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    @Transactional
    @PostMapping
    public ResponseEntity<TestimonialResponse> create(@Valid @RequestBody TestimonialRequest request) throws NotFoundException {

        if(testimonialService.areNull(request)){
            throw new NotFoundException("nome or content are null or empty");
        }

        TestimonialResponse response = testimonialService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @Transactional
    @PutMapping("{id}")
    public ResponseEntity<TestimonialResponse> upDate(@Valid @RequestBody TestimonialRequest request,
                                                      @PathVariable Long id ){

        TestimonialResponse response = testimonialService.upDate(request, id);

        return ResponseEntity.ok(response);

    }

    @Transactional
    @PutMapping("{id}")
    public ResponseEntity<TestimonialResponse> delete(@PathVariable Long id ){

        TestimonialResponse response = testimonialService.delete(id);

        return ResponseEntity.ok(response);

    }

    /*
    private String name;
    private String image;
    private String content;
    private Timestamp timestamp;
    private boolean softDelete;
     */

}
