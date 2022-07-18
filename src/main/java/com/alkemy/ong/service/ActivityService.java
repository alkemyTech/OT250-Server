package com.alkemy.ong.service;

import com.alkemy.ong.models.entity.ActivityEntity;
import com.alkemy.ong.models.request.ActivityRequest;
import com.alkemy.ong.models.request.ActivityRequestUpDate;
import com.alkemy.ong.models.response.ActivityResponse;

import java.util.List;

public interface ActivityService {

    ActivityResponse save(ActivityRequest request);

    ActivityResponse upDate(Long id, ActivityRequestUpDate request);


}
