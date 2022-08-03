package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.CommentRequest;
import com.alkemy.ong.models.request.CommentRequestUpDate;
import com.alkemy.ong.models.response.CommentResponse;
import com.alkemy.ong.models.response.CommentShortResponse;
import com.alkemy.ong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponse> create(@Valid @RequestBody CommentRequest request) {
        CommentResponse commentResponse = commentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResponse);
    }

    @GetMapping
    public ResponseEntity<List<CommentShortResponse>> readComments() {
        List<CommentShortResponse> commentShortResponses = commentService.readComments();
        return ResponseEntity.status(HttpStatus.OK).body(commentShortResponses);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") @NotNull Long id, @RequestHeader(name="Authorization") String token) {
        commentService.delete(id, token);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<CommentResponse> upDate(@Valid @PathVariable("id") @NotNull Long id,
                                       @RequestHeader(name="Authorization") String token,
                                       @Valid @RequestBody CommentRequestUpDate request) throws Exception {

        CommentResponse response = commentService.upDate(id, token, request);
        return ResponseEntity.ok(response);

    }

}
