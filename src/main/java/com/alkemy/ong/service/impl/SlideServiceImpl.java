package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.OrgNotFoundException;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.exception.SlideNotFoundException;
import com.alkemy.ong.models.entity.OrganizationEntity;
import com.alkemy.ong.models.entity.SlideEntity;
import com.alkemy.ong.models.mapper.SlideMapper;
import com.alkemy.ong.models.request.SlideRequest;
import com.alkemy.ong.models.response.SlideResponse;
import com.alkemy.ong.repository.ISlideRepository;
import com.alkemy.ong.repository.OrganizationRepository;
import com.alkemy.ong.service.ISlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SlideServiceImpl implements ISlideService {

    @Autowired
    private ISlideRepository slideRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    SlideMapper slideMapper;

    public SlideResponse create(SlideRequest slideRequest) throws IOException {
        Optional<OrganizationEntity> organization = organizationRepository.findById(slideRequest.getOrganizationId());
        if (!organization.isPresent())
            throw new OrgNotFoundException("Invalid organization id");
        verifySlideRequestOrder(slideRequest);
        SlideEntity slideEntity = slideMapper.slideRequest2SlideEntity(slideRequest);
        slideRepository.save(slideEntity);
        return slideMapper.slideEntity2SlideResponse(slideEntity);
    }

    public SlideResponse update(Long id, SlideRequest slideRequest) throws IOException {
        Optional<SlideEntity> entity = slideRepository.findById(id);
        if (!entity.isPresent())
            throw new SlideNotFoundException("Invalid slide id");
        verifySlideRequestOrder2Update(slideRequest, id);
        slideMapper.updateEntity(entity.get(), slideRequest);
        SlideEntity updatedEntity = slideRepository.save(entity.get());
        return slideMapper.slideEntity2SlideResponse(updatedEntity);
    }

    private void verifySlideRequestOrder2Update(SlideRequest slideRequest, Long id) {
        if (slideRequest.getOrder() == null)
            slideRequest.setOrder(slideRepository.getById(id).getOrder());
        else
            slideRepository.getById(id).setOrder(slideRequest.getOrder());
    }

    private void verifySlideRequestOrder(SlideRequest slideRequest) {
        Integer lastOrder = 1;
        Integer maxOrder = 0;
        if (slideRequest.getOrder() == null) {
            List<SlideEntity> entities = slideRepository.findAllByOrderByOrderDesc();
            if (entities.isEmpty())
                slideRequest.setOrder(lastOrder);
            else
                slideRequest.setOrder(entities.get(maxOrder).getOrder()+lastOrder);
        }
    }

    public List<SlideResponse> graphicalList() {
        List<SlideResponse> slideResponses = new ArrayList<>();
        List<SlideEntity> slideEntities = slideRepository.findAllByOrderByOrderAsc();
        slideResponses = slideMapper.slideList2ResponseGraphicalList(slideEntities);
        return slideResponses;
    }

    public SlideResponse detailsOfSlide(Long id){
        Optional<SlideEntity> slide = slideRepository.findById(id);
        if (slide.isEmpty()) {
            throw new NotFoundException("The Slide with id "+id+" has not be found");
        }
        SlideResponse slideResponse = slideMapper.slideEntity2SlideResponse(slide.get());
        return slideResponse;
    }

    @Override
    public void deleteById(Long id) {
        Optional<SlideEntity> slide = slideRepository.findById(id);
        if (slide.isEmpty()) {
            throw new NotFoundException("The Slide with id "+id+" has not be found");
        }
        slideRepository.deleteById(slide.get().getId());

    }
}