package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.exception.SlideNotFoundException;
import com.alkemy.ong.models.entity.SlideEntity;
import com.alkemy.ong.models.mapper.SlideMapper;
import com.alkemy.ong.models.request.SlideRequest;
import com.alkemy.ong.models.response.SlideResponse;
import com.alkemy.ong.repository.ISlideRepository;
import com.alkemy.ong.service.ISlideService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Optional;

@Service
public class SlideServiceImpl implements ISlideService {

    @Autowired
    private ISlideRepository slideRepository;
    @Autowired
    SlideMapper slideMapper;

    public SlideResponse create(SlideRequest slideRequest) throws IOException {
        verifySlideRequestOrder(slideRequest);
        SlideEntity slideEntity = slideMapper.slideRequest2SlideEntity(slideRequest);
        slideRepository.save(slideEntity);
        return slideMapper.slideEntity2SlideResponse(slideEntity);
    }

    public SlideResponse update(Long id, SlideRequest slideRequest) throws IOException {
        Optional<SlideEntity> entity = isEntityInDatabase(id);
        verifySlideRequestOrder(slideRequest);
        slideMapper.updateEntity(entity.get(), slideRequest);
    }

    private void slideExists(SlideEntity slideGot) {

    }

    private void verifySlideRequestOrder(SlideRequest slideRequest) {
        if (slideRequest.getOrder() == null) {
            try {
                Integer lastOrder = (slideRepository.findAll().get(slideRepository.findAll().size() - 1).getOrder()) + 1;
                slideRequest.setOrder(lastOrder);
            } catch (IndexOutOfBoundsException e) {
                slideRequest.setOrder(1);
            }
            catch (SlideNotFoundException ex){
                throw new SlideNotFoundException("Slide list is empty");
            }
        }
    }

    @NotNull
    private Optional<SlideEntity> isEntityInDatabase(Long id) {
        Optional<SlideEntity> entity = slideRepository.findById(id);
        if (!entity.isPresent())
            throw new ParamNotFound("Invalid slide id");
        return entity;
    }
}
