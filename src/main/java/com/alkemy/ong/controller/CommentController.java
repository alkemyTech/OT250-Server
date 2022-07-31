package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.CommentRequest;
import com.alkemy.ong.models.response.CommentResponse;
import com.alkemy.ong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponse> create(@Valid @RequestBody CommentRequest request) {
        CommentResponse commentResponse = commentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResponse);
    }
}
