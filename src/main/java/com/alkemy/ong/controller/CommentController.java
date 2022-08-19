package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.CommentRequest;
import com.alkemy.ong.models.request.CommentRequestUpDate;
import com.alkemy.ong.models.response.CommentResponse;
import com.alkemy.ong.models.response.CommentShortResponse;
import com.alkemy.ong.service.CommentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/comments")
@Api(description = "This API has a CRUD for Comments", tags = "Comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create comment ", notes = "Create a category ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Created Category"),
            @ApiResponse(code = 400, message = "Bad Request"),})
    @PostMapping
    public ResponseEntity<CommentResponse> create(@RequestHeader(name="Authorization") String token,
                                                  @Valid @RequestBody CommentRequest request) {
        CommentResponse commentResponse = commentService.create(request, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResponse);

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get All by comments ", notes = "Get All a comments")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Founds Comments"),
            @ApiResponse(code = 400, message = "Bad Request"),
                    })
    @GetMapping
    public ResponseEntity<List<CommentShortResponse>> readComments() {
        List<CommentShortResponse> commentShortResponses = commentService.readComments();
        return ResponseEntity.status(HttpStatus.OK).body(commentShortResponses);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete comment ", notes = "Delete a comment by ID")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Deleted Comment"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Comment required by id Not Found"),})
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable@NotNull @NotBlank @ApiParam(
                                                        name = "id",
                                                        type = "Long",
                                                        value = "ID of the comment",
                                                        example = "1",
                                                        required = true ) Long id,
                                                        @RequestHeader(name="Authorization") String token) {

        commentService.delete(id, token);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Update comments by ID", notes = "Allows the user to update existing comments by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Comment updated!"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Comment required by id Not Found"),})
    @PutMapping("{id}")
    public ResponseEntity<CommentResponse> upDate(@Valid @PathVariable("id") @NotNull Long id,
                                       @RequestHeader(name="Authorization") String token,
                                       @Valid @RequestBody CommentRequestUpDate request) throws Exception {

        CommentResponse response = commentService.upDate(id, token, request);
        return ResponseEntity.ok(response);

    }

}
