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

import java.io.IOException;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    private TestimonialMapper testimonialMapper;
    @Autowired
    private TestimonialRepository testimonialRepository;

    @Override
    public TestimonialResponse save(TestimonialRequest request) throws IOException {

        if(areNull(request.getName())||areNull(request.getContent())){
            throw new NotFoundException("nome or content are null or empty");
        }

        TestimonialEntity entitySave = testimonialMapper.request2Entity(request);
        TestimonialEntity entity = testimonialRepository.save(entitySave);
        TestimonialResponse response = testimonialMapper.entity2Response(entity);

        return response;
    }

    @Override
    public TestimonialResponse upDate(TestimonialRequest request, Long id) throws NotFoundException {

        TestimonialEntity entityFound = testimonialRepository.findById(id).orElseThrow();

       /* if(request.getTimestamp() != null){
            entityFound.setTimestamp(request.getTimestamp());
        } */
        if(!request.getImage().isBlank() || !request.getImage().isEmpty() || request.getImage() !=null){
            entityFound.setImage(request.getImage());
        }
        if(!request.getContent().isBlank() || !request.getContent().isEmpty() || request.getContent() !=null){
            entityFound.setContent(request.getContent());
        }
        if(!request.getName().isBlank() || !request.getName().isEmpty() || request.getName() !=null){
            entityFound.setName(request.getName());
        }

        testimonialRepository.save(entityFound);

        TestimonialResponse response = testimonialMapper.entity2Response(entityFound);

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

    public boolean areNull(String request) {

        if(request.isEmpty() || request == null || request.isBlank()){
            return true;
        }
        return false;

    }


}
