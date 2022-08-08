package com.alkemy.ong.controller;


import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.CommentShortResponse;
import com.alkemy.ong.models.response.CommentsByNewsResponse;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.service.CommentService;
import com.alkemy.ong.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsService newsService;
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<NewsResponse> createNews (@Valid @RequestBody NewsRequest newsRequest){

        NewsResponse newsResponseCreate = this.newsService.create(newsRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(newsResponseCreate);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNews (@PathVariable Long id){

        this.newsService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("{id}")
    public ResponseEntity<NewsResponse> updateNews (@PathVariable Long id,
                                                    @Valid @RequestBody NewsRequest newsRequest) {

        NewsResponse newsResponse = this.newsService.update(id, newsRequest);

        return ResponseEntity.status(HttpStatus.OK).body(newsResponse);

    }

    @GetMapping("{id}")
    public ResponseEntity<NewsResponse> getById (@PathVariable Long id){

        NewsResponse response = this.newsService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("{newsID}/comments")
    public ResponseEntity<List<CommentsByNewsResponse>> commentsByNewsID(@PathVariable Long newsID) {
        List<CommentsByNewsResponse> response = commentService.readCommentsByNewsID(newsID);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
