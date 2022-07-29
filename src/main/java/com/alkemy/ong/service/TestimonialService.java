package com.alkemy.ong.service;

import com.alkemy.ong.models.request.TestimonialRequest;
import com.alkemy.ong.models.response.TestimonialResponse;

public interface TestimonialService {

    boolean areNull(TestimonialRequest request);

    TestimonialResponse save(TestimonialRequest request);

    TestimonialResponse upDate(TestimonialRequest request);

    TestimonialResponse delete(Long id);

}
