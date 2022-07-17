package com.alkemy.ong.service;

import com.alkemy.ong.exception.OrgNotFoundException;
import com.alkemy.ong.models.request.OrganizationRequest;
import com.alkemy.ong.models.response.OrganizationResponse;
import com.alkemy.ong.models.response.OrganizationResponseInfo;

import java.util.List;

public interface OrganizationService {

    public OrganizationResponse save(OrganizationRequest request);
    
    public List<OrganizationResponseInfo> GetInfo();
    
    public OrganizationResponse update(Long id, OrganizationRequest request) throws OrgNotFoundException; 
}
