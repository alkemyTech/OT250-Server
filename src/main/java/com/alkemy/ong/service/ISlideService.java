package com.alkemy.ong.service;

import com.alkemy.ong.models.request.SlideRequest;
import com.alkemy.ong.models.response.SlideResponse;

import java.io.IOException;
import java.util.List;

public interface ISlideService {

    SlideResponse create(SlideRequest slideRequest) throws IOException;

    SlideResponse update(Long id, SlideRequest slideRequest) throws IOException;

    public List<SlideResponse> graphicalList();

    public SlideResponse detailsOfSlide(Long id);

    void deleteById(Long id);
}
