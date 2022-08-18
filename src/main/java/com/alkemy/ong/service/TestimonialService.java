package com.alkemy.ong.service;

import com.alkemy.ong.models.request.TestimonialRequest;
import com.alkemy.ong.models.response.PaginationResponse;
import com.alkemy.ong.models.response.TestimonialResponse;

import java.io.IOException;
import java.util.Optional;

public interface TestimonialService {


    TestimonialResponse save(TestimonialRequest request) throws IOException;

    TestimonialResponse upDate(TestimonialRequest request, Long id);

    TestimonialResponse delete(Long id);

    PaginationResponse getPage(Optional<Integer> pageNumber, Optional<Integer> size);

}
