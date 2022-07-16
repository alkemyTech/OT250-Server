package com.alkemy.ong.service.impl;

import com.alkemy.ong.models.request.SlideRequest;
import com.alkemy.ong.models.response.SlideResponse;
import com.alkemy.ong.repository.ISlideRepository;
import com.alkemy.ong.service.ISlideService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class SlideServiceImpl implements ISlideService {

    @Autowired
    private ISlideRepository slideRepository;

    public SlideResponse create(SlideRequest slideRequest) throws IOException {
        return null;
    }

    private void verification(SlideRequest slideRequest) {
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
}
