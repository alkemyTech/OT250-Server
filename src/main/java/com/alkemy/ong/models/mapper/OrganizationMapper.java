package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.OrganizationEntity;
import com.alkemy.ong.models.request.OrganizationUpdatelRequest;
import com.alkemy.ong.models.request.OrganizationRequest;
import com.alkemy.ong.models.response.OrganizationResponse;
import com.alkemy.ong.models.response.OrganizationResponseInfo;
import com.alkemy.ong.service.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OrganizationMapper {

    @Autowired
    private AwsService awsService;

    public OrganizationEntity requestToEntity(OrganizationRequest request) throws IOException {
        OrganizationEntity entity = new OrganizationEntity();
        entity.setName(request.getName());
        entity.setImage(awsService.uploadFileFromBase64(request.getImage()));
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
    
    public OrganizationEntity updateEntity(OrganizationEntity entity, OrganizationRequest request) throws IOException {
        
         if(!request.getName().isEmpty()){
            entity.setName(request.getName());
        }

        if(!request.getImage().isEmpty()){
            entity.setImage(awsService.uploadFileFromBase64(request.getImage()));
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

    public OrganizationEntity basicUpdateEntity(OrganizationEntity entity, OrganizationUpdatelRequest request) throws IOException {

        if(request.getName() != null && !request.getName().isEmpty() && !request.getName().isBlank()){
            entity.setName(request.getName());
        }

        if(request.getImage() != null && !request.getImage().isEmpty() && !request.getImage().isBlank() ){
            entity.setImage(awsService.uploadFileFromBase64(request.getImage()));
        }

        if (request.getAddress()!=null && !request.getAddress().isEmpty() && !request.getAddress().isBlank()){
            entity.setAddress(request.getAddress());
        }

        if (request.getPhone()!= null){
            entity.setPhone(request.getPhone());
        }

        if ( request.getEmail() != null &&!request.getEmail().isEmpty() && !request.getEmail().isBlank()){
        entity.setEmail(request.getEmail());
    }

        if (request.getWelcomeText() != null && !request.getWelcomeText().isEmpty() && !request.getWelcomeText().isBlank()){
        entity.setWelcomeText(request.getWelcomeText());
    }

        if (request.getAboutUsText()!= null && !request.getAboutUsText().isEmpty() && !request.getAboutUsText().isBlank() ){
        entity.setAboutUsText(request.getAboutUsText());
    }

        return entity;
    }
}
