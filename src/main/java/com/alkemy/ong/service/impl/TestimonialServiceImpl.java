package com.alkemy.ong.service.impl;

import com.alkemy.ong.models.entity.TestimonialEntity;
import com.alkemy.ong.models.mapper.TestimonialMapper;
import com.alkemy.ong.models.request.TestimonialRequest;
import com.alkemy.ong.models.response.TestimonialResponse;
import com.alkemy.ong.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    private TestimonialMapper testimonialMapper;

    @Override
    public boolean areNull(TestimonialRequest request) {
        if(request.getName().isEmpty() || request.getName() == null ||
                request.getContent().isEmpty() || request.getContent() == null){
            return true;
        }
        return false;
    }

    @Override
    public TestimonialResponse save(TestimonialRequest request) {
        TestimonialEntity entity = new TestimonialEntity();
        entity =
        return null;
    }

    @Override
    public TestimonialResponse upDate(TestimonialRequest request) {
        return null;
    }

    @Override
    public TestimonialResponse delete(Long id) {
        return null;
    }
}
