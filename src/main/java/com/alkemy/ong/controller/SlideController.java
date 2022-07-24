package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.SlideRequest;
import com.alkemy.ong.models.response.SlideResponse;
import com.alkemy.ong.service.ISlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/slides")
public class SlideController {

    @Autowired
    private ISlideService slideService;

    @PostMapping
    public ResponseEntity<SlideResponse> create(@RequestBody @Valid SlideRequest slideRequest) throws IOException {
        SlideResponse responseSaved = slideService.create(slideRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseSaved);
    }

    @PutMapping("{id}")
    public ResponseEntity<SlideResponse> update(
            @PathVariable Long id, @RequestBody @Valid SlideRequest slideRequest) throws IOException {
        SlideResponse slideUpdated = slideService.update(id, slideRequest);
        return ResponseEntity.status(HttpStatus.OK).body(slideUpdated);
    }

    @GetMapping
    public ResponseEntity<List<SlideResponse>> graphicalList() {
        List<SlideResponse> slideResponses = slideService.graphicalList();
        return ResponseEntity.status(HttpStatus.OK).body(slideResponses);
    }

}
