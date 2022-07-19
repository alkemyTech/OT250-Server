package com.alkemy.ong.service;

import com.alkemy.ong.models.request.ActivityRequest;
import com.alkemy.ong.models.request.ActivityRequestUpDate;
import com.alkemy.ong.models.response.ActivityResponse;

public interface ActivityService {

    ActivityResponse save(ActivityRequest request);

    ActivityResponse upDate(Long id, ActivityRequestUpDate request);

    boolean isNull(ActivityRequest request);

}
