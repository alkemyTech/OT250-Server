package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.ActivityNotFoundException;
import com.alkemy.ong.exception.NameOrContentAreNull;
import com.alkemy.ong.models.entity.ActivityEntity;
import com.alkemy.ong.models.mapper.ActivityMapper;
import com.alkemy.ong.models.request.ActivityRequest;
import com.alkemy.ong.models.request.ActivityRequestUpDate;
import com.alkemy.ong.models.response.ActivityResponse;
import com.alkemy.ong.repository.ActivityRepository;
import com.alkemy.ong.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {


    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ActivityMapper activityMapper;

    public boolean isNull(ActivityRequest request) throws NameOrContentAreNull {

        try{
            if(request.getName() == null || request.getName().isEmpty() ||
                    request.getContent() == null || request.getContent().isEmpty()){

                throw new NameOrContentAreNull("impl - name or content are null");

            }
        }catch(NameOrContentAreNull ex){

            throw new NameOrContentAreNull("catch - name or content are null");

        }

        return false;
    }


    @Override
    public ActivityResponse save(ActivityRequest request) throws NameOrContentAreNull{

        ActivityEntity entitySave = activityMapper.request2Entity(request);

        activityRepository.save(entitySave);

        ActivityResponse response = activityMapper.entity2Response(entitySave);

        return response;
    }

    @Override
    public ActivityResponse upDate(Long id, ActivityRequestUpDate request) throws ActivityNotFoundException{

        try {

            if (activityRepository.findById(id).isPresent()) {

                ActivityEntity entityFound = activityRepository.findById(id).orElseThrow();

                ActivityEntity entitySave = activityMapper.requestUpDate2Entity(entityFound, request);

                activityRepository.save(entitySave);

                ActivityResponse response = activityMapper.entity2Response(entitySave);

                return response;

            }else{

                throw new ActivityNotFoundException ("\n\n else - Not Found Activity \n");
            }

        }catch(ActivityNotFoundException aex){

            throw new ActivityNotFoundException("\n catch - Not Found Activity  ");

        }

    }

}
