package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.OrgNotFoundException;
import com.alkemy.ong.models.entity.OrganizationEntity;
import com.alkemy.ong.models.entity.SlideEntity;
import com.alkemy.ong.models.mapper.OrganizationMapper;
import com.alkemy.ong.models.mapper.SlideMapper;
import com.alkemy.ong.models.request.OrganizationUpdatelRequest;
import com.alkemy.ong.models.request.OrganizationRequest;
import com.alkemy.ong.models.response.OrganizationResponse;
import com.alkemy.ong.models.response.OrganizationResponseInfo;
import com.alkemy.ong.repository.ISlideRepository;
import com.alkemy.ong.repository.OrganizationRepository;
import com.alkemy.ong.service.AwsService;
import com.alkemy.ong.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;
    
    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private ISlideRepository slideRepository;

    @Autowired
    private SlideMapper slideMapper;

    @Autowired
    private AwsService awsService;
    
    @Override
    public OrganizationResponse save(OrganizationRequest request) throws IOException {
        OrganizationEntity entity = organizationMapper.requestToEntity(request);
        organizationRepository.save(entity);
        return organizationMapper.entityToResponse(entity);
    }

    @Override
    public List<OrganizationResponseInfo> GetInfo() {
        List<OrganizationEntity> entities = organizationRepository.findAll();
        List<OrganizationResponseInfo> responses = new ArrayList<>();
        for (OrganizationEntity entity : entities) {
            OrganizationResponseInfo response;
            response = organizationMapper.entityToResponseInfo(entity);
            List<SlideEntity> slides = slideRepository.findAllByOrganizationIdOrderByOrderAsc(entity.getId());
            response.setSlides(slideMapper.slideList2ResponseGraphicalList(slides));
            responses.add(response);

        }
        return responses;
    }

    @Override
    public OrganizationResponse update(Long id, OrganizationRequest request) throws OrgNotFoundException, IOException {
        OrganizationEntity entity = organizationRepository.findById(id).orElse(null);
        
        if(entity==null){
            throw new OrgNotFoundException("No organization found with that id");
        }
        
        entity = organizationMapper.updateEntity(entity, request);
        organizationRepository.save(entity);
        OrganizationResponse response = organizationMapper.entityToResponse(entity);
        
        return response;
    }

    @Override
    public OrganizationResponse basicUpdate(Long id, OrganizationUpdatelRequest request) throws IOException {

         OrganizationEntity entity = organizationRepository.findById(id).orElse(null);
         if(entity == null){ throw new OrgNotFoundException("No organization found with that id");
         }

        OrganizationEntity update = organizationMapper.basicUpdateEntity(entity,request);
        OrganizationResponse response = organizationMapper.entityToResponse(update);

        return response;
    }
}
