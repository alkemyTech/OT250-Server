package com.alkemy.ong.controller;


import com.alkemy.ong.auth.security.SwaggerConfig;
import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.CommentShortResponse;
import com.alkemy.ong.models.response.CommentsByNewsResponse;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.models.response.PaginationResponse;
import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.service.CommentService;
import com.alkemy.ong.service.NewsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("news")
@Api(description ="News CRUD" , tags = "News")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsService newsService;
    @Autowired
    private CommentService commentService;

    @PostMapping
    @ApiOperation(value = "Create News", notes = "Allows Admin to insert news")
    @ApiResponses({@ApiResponse(code = 201, message = "News created!")})
    public ResponseEntity<NewsResponse> createNews (@Valid @RequestBody  NewsRequest newsRequest) throws IOException {

        NewsResponse newsResponseCreate = this.newsService.create(newsRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(newsResponseCreate);
    }


    @DeleteMapping("{id}")
    @ApiOperation(value = "Soft Delete News By ID", notes = "Allows Admin to delete news by ID")
    @ApiResponses({@ApiResponse(code = 204, message = "News soft deleted!"),
                   @ApiResponse(code = 404, message = "The inserted ID does not belong to a news")})
    public ResponseEntity<Void> deleteNews (@PathVariable @Valid @NotNull @NotBlank @ApiParam(
                                             name = "id",
                                             type = "Long",
                                             value = "ID of the news requested",
                                             example = "1",
                                             required = true) Long id){

        this.newsService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("{id}")
    @ApiOperation(value = "Update News By ID", notes = "Allows Admin to update an existing news by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "News updated!"),
            @ApiResponse(code = 404, message = "The inserted ID does not belong to a news")})
    public ResponseEntity<NewsResponse> updateNews (@PathVariable @Valid @NotNull @NotBlank  @ApiParam(
                                                    name = "id",
                                                    type = "Long",
                                                    value = "ID of the news requested",
                                                    example = "1",
                                                    required = true) Long id,
                                                    @Valid @RequestBody @ApiParam(
                                                    name = "New News",
                                                    value = "News to save",
                                                    required = true) NewsRequest newsRequest) throws IOException {

        NewsResponse newsResponse = this.newsService.update(id, newsRequest);

        return ResponseEntity.status(HttpStatus.OK).body(newsResponse);

    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get News By ID", notes = "Returns all details of news by ID")
    @ApiResponses({@ApiResponse(code = 200, message = "Return the requested news"),
                   @ApiResponse(code = 404, message = "The inserted ID does not belong to a news")})
    public ResponseEntity<NewsResponse> getById (@PathVariable @Valid @NotNull @NotBlank @ApiParam(
                                                    name = "id",
                                                    type = "Long",
                                                    value = "ID of the news requested",
                                                    example = "1",
                                                    required = true) Long id){

        NewsResponse response = this.newsService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("{newsID}/comments")
    @ApiOperation(value = "Get Comments By News ID", notes = "Returns all the comments according to the News ID")
    @ApiResponses({@ApiResponse(code = 200, message = "Return the requested comments"),
            @ApiResponse(code = 404, message = "The inserted ID does not belong to a news")})
    public ResponseEntity<?> commentsByNewsID(@PathVariable @Valid @NotNull @NotBlank @ApiParam(
                                                name = "newsID",
                                                type = "Long",
                                                value = "ID of the news requested",
                                                example = "1",
                                                required = true) Long newsID,
                                              @RequestParam(value = "page", required = false) Optional<Integer> page,
                                              @RequestParam(value = "size", required = false) Optional<Integer> size) {

       return new ResponseEntity<>(commentService.getPageCommentsByNews(page, size), HttpStatus.OK);
    }

        @GetMapping
        @ApiOperation(value = "Get  All News" , notes = "Returns All News ")
        @ApiResponses({@ApiResponse(code = 200, message = "Return All news created"),
                       @ApiResponse(code = 400, message = "Bad Request")})
        public ResponseEntity<?> getAllNews (@RequestParam(value = "page", required = false) Optional<Integer> page,
                                             @RequestParam(value = "size", required = false) Optional<Integer> size) {

            return new ResponseEntity<>(newsService.getPage(page, size), HttpStatus.OK);

        }
}
