package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.models.entity.TestimonialEntity;
import com.alkemy.ong.models.mapper.TestimonialMapper;
import com.alkemy.ong.models.request.TestimonialRequest;
import com.alkemy.ong.models.response.TestimonialResponse;
import com.alkemy.ong.repository.TestimonialRepository;
import com.alkemy.ong.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    private TestimonialMapper testimonialMapper;
    @Autowired
    private TestimonialRepository testimonialRepository;

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

        TestimonialEntity entitySave = testimonialMapper.request2Entity(request);
        testimonialRepository.save(entitySave);
        TestimonialResponse response = testimonialMapper.entity2Response(entitySave);

        return response;
    }

    @Override
    public TestimonialResponse upDate(TestimonialRequest request, Long id) throws NotFoundException {

        TestimonialEntity entityFound = testimonialRepository.findById(id).orElseThrow();
        TestimonialEntity entity = testimonialMapper.request2EntityUpDate(entityFound, request);
        testimonialRepository.save(entity);
        TestimonialResponse response = testimonialMapper.entity2Response(entity);

        return response;
    }

    @Override
    public TestimonialResponse delete(Long id) {

        TestimonialEntity entity = testimonialRepository.findById(id).orElseThrow();

        if(!testimonialRepository.findById(id).isPresent()){
            throw new NotFoundException("no se encontro el testimonial");
        }

        testimonialRepository.delete(entity);

        return null;
    }
}
