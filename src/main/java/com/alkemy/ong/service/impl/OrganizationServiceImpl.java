package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.OrgNotFoundException;
import com.alkemy.ong.models.entity.OrganizationEntity;
import com.alkemy.ong.models.mapper.OrganizationMapper;
import com.alkemy.ong.models.request.OrganizationRequest;
import com.alkemy.ong.models.response.OrganizationResponse;
import com.alkemy.ong.models.response.OrganizationResponseInfo;
import com.alkemy.ong.repository.OrganizationRepository;
import com.alkemy.ong.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;
    
    @Autowired
    private OrganizationMapper organizationMapper;
    
    @Override
    public OrganizationResponse save(OrganizationRequest request) {
        OrganizationEntity entity = organizationMapper.requestToEntity(request);
        organizationRepository.save(entity);
        return organizationMapper.entityToResponse(entity);
    }

    @Override
    public List<OrganizationResponseInfo> GetInfo() {
        List<OrganizationEntity> entities = organizationRepository.findAll();
        List<OrganizationResponseInfo> response = new ArrayList();
        for (OrganizationEntity entity : entities) {
            response.add(organizationMapper.entityToResponseInfo(entity));
        }
        return response;
    }

    @Override
    public OrganizationResponse update(Long id, OrganizationRequest request) throws OrgNotFoundException{
        OrganizationEntity entity = organizationRepository.findById(id).orElse(null);
        
        if(entity==null){
            throw new OrgNotFoundException("No organization found with that id");
        }
        
        entity = organizationMapper.updateEntity(entity, request);
        organizationRepository.save(entity);
        
        return organizationMapper.entityToResponse(entity);
    }
}
