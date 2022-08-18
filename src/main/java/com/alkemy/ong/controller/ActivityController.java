package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.ActivityRequest;
import com.alkemy.ong.models.request.ActivityRequestUpDate;
import com.alkemy.ong.models.response.ActivityResponse;
import com.alkemy.ong.service.ActivityService;
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
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/activities")
@Api(description = "Activity CRUD", tags = "Activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Transactional
    @ApiOperation(value = "create activity", notes = "por request llegan toda la info necesaria para cear una actividad")
    @ApiResponses(value = {
                @ApiResponse( code = 201, message = "created"),
                @ApiResponse( code = 400, message = "bad request"),
                @ApiResponse( code = 403, message = "forbidden")
                            })
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
