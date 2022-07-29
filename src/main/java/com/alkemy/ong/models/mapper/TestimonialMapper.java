package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.TestimonialEntity;
import com.alkemy.ong.models.request.TestimonialRequest;
import com.alkemy.ong.models.response.TestimonialResponse;

import java.sql.Timestamp;

public class TestimonialMapper {

    public TestimonialEntity request2Entity(TestimonialRequest request){

        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);

        return TestimonialEntity.builder()
                .name(request.getName())
                .content(request.getContent())
                .image(request.getImage())
                .timestamp(timestamp)
                .build();
    }

    public TestimonialResponse entity2Response(TestimonialEntity entity){

        TestimonialResponse response = new TestimonialResponse(
                entity.getName(),
                entity.getContent(),
                entity.getImage(),
                entity.getTimestamp());

        return response;

    }

    public TestimonialEntity request2EntityUpDate(TestimonialEntity entityFound, TestimonialRequest request){

        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);

        return entityFound.builder()
                .name(request.getName())
                .content(request.getContent())
                .image(request.getImage())
                .timestamp(timestamp)
                .build();
    }



}
