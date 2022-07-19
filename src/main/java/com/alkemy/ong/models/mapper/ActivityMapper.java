package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.ActivityEntity;
import com.alkemy.ong.models.request.ActivityRequest;
import com.alkemy.ong.models.request.ActivityRequestUpDate;
import com.alkemy.ong.models.response.ActivityResponse;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
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

    public ActivityEntity requestUpDate2Entity(ActivityRequestUpDate request){

        ActivityEntity entity = new ActivityEntity();

        entity.setId(request.getId());
        entity.setContent(request.getContent());
        entity.setImage(request.getImage());
        entity.setName(request.getName());
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        entity.setTimestamp(timestamp);

        return entity;

    }

}
