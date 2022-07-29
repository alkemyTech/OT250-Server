package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.TestimonialEntity;
import com.alkemy.ong.models.request.TestimonialRequest;

import java.sql.Timestamp;

public class TestimonialMapper {

//    public TestimonialEntity request2Entity(TestimonialRequest request){
//
//        TestimonialEntity entity = new TestimonialEntity();
//
//        entity.setContent(request.getContent());
//        entity.setName(request.getName());
//        entity.setImage(request.getImage());
//        Long datetime = System.currentTimeMillis();
//        Timestamp timestamp = new Timestamp(datetime);
//        entity.setTimestamp(timestamp);
//
//        return entity;
//
//    }

    public TestimonialEntity request2Entity(TestimonialRequest request){
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
           return TestimonialEntity.builder()
                .content(request.getContent())
                .name(request.getName())
                .image(request.getImage())
                .timestamp(timestamp)
                .build();
    }




}
