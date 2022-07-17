package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.ParamNotFoundException;
import com.alkemy.ong.exception.SlideNotFoundException;
import com.alkemy.ong.models.entity.SlideEntity;
import com.alkemy.ong.models.mapper.SlideMapper;
import com.alkemy.ong.models.request.SlideRequest;
import com.alkemy.ong.models.response.SlideResponse;
import com.alkemy.ong.repository.ISlideRepository;
import com.alkemy.ong.service.ISlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
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
        Optional<SlideEntity> entity = slideRepository.findById(id);
        if (!entity.isPresent())
            throw new ParamNotFoundException("Invalid slide id");
        verifySlideRequestOrder(slideRequest);
        slideMapper.updateEntity(entity.get(), slideRequest);
        SlideEntity updatedEntity = slideRepository.save(entity.get());
        return slideMapper.slideEntity2SlideResponse(updatedEntity);
    }

    private void verifySlideRequestOrder(SlideRequest slideRequest) {
        if (slideRequest.getOrder() == null) {
            try {
                List<SlideEntity> lastOrder = slideRepository.findAllByOrderByOrderDesc();
                slideRequest.setOrder(lastOrder.get(0).getOrder()+1);
            } catch (IndexOutOfBoundsException e) {
                slideRequest.setOrder(1);
            }
            catch (SlideNotFoundException ex){
                throw new SlideNotFoundException("Slide list is empty");
            }
        }
    }
}
