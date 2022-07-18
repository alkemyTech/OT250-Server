package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.OrganizationEntity;
import com.alkemy.ong.models.request.OrganizationRequest;
import com.alkemy.ong.models.response.OrganizationResponse;
import com.alkemy.ong.models.response.OrganizationResponseInfo;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper {

    public OrganizationEntity requestToEntity(OrganizationRequest request){
        OrganizationEntity entity = new OrganizationEntity();
        entity.setName(request.getName());
        entity.setImage(request.getImage());
        entity.setAddress(request.getAddress());
        entity.setPhone(request.getPhone());
        entity.setEmail(request.getEmail());
        entity.setWelcomeText(request.getWelcomeText());
        entity.setAboutUsText(request.getAboutUsText());
        entity.setUrlFacebook(request.getUrlFacebook());
        entity.setUrlInstagram(request.getUrlInstagram());
        entity.setUrlLinkedin(request.getUrlLinkedin());
        return entity;
    }
    
    public OrganizationResponse entityToResponse(OrganizationEntity entity){
        OrganizationResponse response = new OrganizationResponse();
        response.setName(entity.getName());
        response.setImage(entity.getImage());
        response.setAddress(entity.getAddress());
        response.setPhone(entity.getPhone());
        response.setEmail(entity.getEmail());
        response.setWelcomeText(entity.getWelcomeText());
        response.setAboutUsText(entity.getAboutUsText());
        response.setUrlFacebook(entity.getUrlFacebook());
        response.setUrlInstagram(entity.getUrlInstagram());
        response.setUrlLinkedin(entity.getUrlLinkedin());
        return response;
    }
    
    public OrganizationResponseInfo entityToResponseInfo(OrganizationEntity entity){
        OrganizationResponseInfo response = new OrganizationResponseInfo();
        response.setName(entity.getName());
        response.setImage(entity.getImage());
        response.setAddress(entity.getAddress());
        response.setPhone(entity.getPhone());

        return response;
    }
    
    public OrganizationEntity updateEntity(OrganizationEntity entity, OrganizationRequest request){
        
         if(!request.getName().isEmpty()){
            entity.setName(request.getName());
        }

        if(!request.getImage().isEmpty()){
            entity.setImage(request.getImage());
        }

        if (request.getAddress()!=null && !request.getAddress().isEmpty()){
            entity.setAddress(request.getAddress());
        }

        if (request.getPhone()!= null){
            entity.setPhone(request.getPhone());
        }

        if (!request.getEmail().isEmpty()){
            entity.setEmail(request.getEmail());
        }

        if (!request.getWelcomeText().isEmpty()){
            entity.setWelcomeText(request.getWelcomeText());
        }

        if (request.getAboutUsText()!=null && !request.getAboutUsText().isEmpty()){
            entity.setAboutUsText(request.getAboutUsText());
        }

        return entity;
    }
}
