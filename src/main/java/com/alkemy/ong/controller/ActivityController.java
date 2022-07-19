package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.ActivityRequest;
import com.alkemy.ong.models.request.ActivityRequestUpDate;
import com.alkemy.ong.models.response.ActivityResponse;
import com.alkemy.ong.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Transactional
    @PostMapping()
    public ResponseEntity<ActivityResponse> create(@Valid @RequestBody ActivityRequest request) throws Exception {

        ActivityResponse response = new ActivityResponse();

        if (activityService.isNull(request)) {

            return ResponseEntity.badRequest().body(response);
        }

        response = activityService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Object> upDate(@Valid @RequestBody ActivityRequestUpDate request, @PathVariable ("id") @Valid @NotNull Long id){

        ActivityResponse response =  activityService.upDate(id, request);

        return ResponseEntity.ok(response);


    }

}
