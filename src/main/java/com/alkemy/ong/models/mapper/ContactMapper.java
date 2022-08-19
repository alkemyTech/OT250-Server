package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.ContactEntity;
import com.alkemy.ong.models.request.ContactRequest;
import com.alkemy.ong.models.response.ContactResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactMapper {

    public ContactEntity request2Entity(ContactRequest request){

        ContactEntity entity = new ContactEntity();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setMessage(request.getMessage());
        entity.setPhone(request.getPhone());

        return entity;

    }

    public ContactResponse entity2Response(ContactEntity entity){

        ContactResponse response = new ContactResponse();

        response.setName(entity.getName());
        response.setEmail(entity.getEmail());
        response.setMessage(entity.getMessage());
        response.setPhone(entity.getPhone());

        return response;


    }

    public List<ContactResponse> entityList2Response(List<ContactEntity> contacts){
        List<ContactResponse> responses = new ArrayList<>();
        for ( ContactEntity contact: contacts){
           responses.add(entity2Response(contact));
        }

        return responses;
    }
}
