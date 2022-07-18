package com.alkemy.ong.service;

import com.alkemy.ong.models.request.SlideRequest;
import com.alkemy.ong.models.response.SlideResponse;

import java.io.IOException;

public interface ISlideService {

    SlideResponse create(SlideRequest slideRequest) throws IOException;

    SlideResponse update(Long id, SlideRequest slideRequest) throws IOException;
}
