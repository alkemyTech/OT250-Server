package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.ActivityEntity;
import com.alkemy.ong.models.entity.ContactEntity;
import com.alkemy.ong.models.request.ActivityRequest;
import com.alkemy.ong.models.request.ActivityRequestUpDate;
import com.alkemy.ong.models.response.ActivityResponse;
import com.alkemy.ong.models.response.ContactResponse;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class ActivityMapper {


    public ActivityEntity request2Entity(ActivityRequest request){

        ActivityEntity entity = new ActivityEntity();

        entity.setContent(request.getContent());
        entity.setImage(request.getImage());
        entity.setName(request.getName());
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        entity.setTimestamp(timestamp);

        return entity;

    }

    public ActivityResponse entity2Response(ActivityEntity entity){

        ActivityResponse response = new ActivityResponse();

        response.setContent(entity.getContent());
        response.setImage(entity.getImage());
        response.setName(entity.getName());
        response.setTimestamp(entity.getTimestamp());

        return response;

    }

    public ActivityEntity requestUpDate2Entity(ActivityEntity entityFound, ActivityRequestUpDate request){

        entityFound.setContent(request.getContent());
        entityFound.setImage(request.getImage());
        entityFound.setName(request.getName());
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        entityFound.setTimestamp(timestamp);

        return entityFound;

    }

    public List<ActivityResponse> toResponseList(List<ActivityEntity> activities){
        List<ActivityResponse> responses = new ArrayList<>();
        for ( ActivityEntity activity: activities){
            responses.add(entity2Response(activity));
        }
        return responses;
    }

}
