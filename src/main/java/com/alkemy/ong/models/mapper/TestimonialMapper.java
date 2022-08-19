package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.TestimonialEntity;
import com.alkemy.ong.models.request.TestimonialRequest;
import com.alkemy.ong.models.response.TestimonialResponse;
import com.alkemy.ong.service.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestimonialMapper {

    @Autowired
    private AwsService awsService;

    public TestimonialEntity request2Entity(TestimonialRequest request) throws IOException {

         Timestamp timestamp = new Timestamp(System.currentTimeMillis());

         TestimonialEntity entity = new TestimonialEntity();

         entity.setName(request.getName());
         entity.setImage(awsService.uploadFileFromBase64(request.getImage()));
         entity.setContent(request.getContent());
         entity.setTimestamp(timestamp);

         return entity;

    }

    public TestimonialResponse entity2Response(TestimonialEntity entity){

        TestimonialResponse response = new TestimonialResponse();

        response.setName(entity.getName());
        response.setContent(entity.getContent());
        response.setImage(entity.getImage());
        response.setTimestamp(entity.getTimestamp());

        return response;

    }

    public List<TestimonialResponse> entity2ResponseList(List<TestimonialEntity> entities){

        List<TestimonialResponse> responses = new ArrayList<>();
        for ( TestimonialEntity entity:entities){
            responses.add(entity2Response(entity));
        }

        return responses;
    }



}
