package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.SlideEntity;
import com.alkemy.ong.models.request.SlideRequest;
import com.alkemy.ong.models.response.SlideResponse;
import com.alkemy.ong.service.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SlideMapper {


    @Autowired
    private AwsService awsService;

    public SlideEntity slideRequest2SlideEntity(SlideRequest slideRequest) throws IOException {
        return SlideEntity.builder()
                .text(slideRequest.getText())
                .order(slideRequest.getOrder())
                .organizationId(slideRequest.getOrganizationId())
                .deleted(Boolean.FALSE)
                .imageUrl(awsService.uploadFileFromBase64(slideRequest.getImageUrl()))
                .build();
    }

    public SlideResponse slideEntity2SlideResponse(SlideEntity slideEntity) {
        SlideResponse response = new SlideResponse();
        response.setId(slideEntity.getId());
        response.setImageUrl(slideEntity.getImageUrl());
        response.setOrganizationId(slideEntity.getOrganizationId());
        response.setOrder(slideEntity.getOrder());
        response.setText(slideEntity.getText());
        return response;
    }

    public void updateEntity(SlideEntity slideEntity, SlideRequest slideRequest) throws IOException {
        slideEntity.setImageUrl(awsService.uploadFileFromBase64(slideRequest.getImageUrl()));
        slideEntity.setText(slideRequest.getText());
        slideEntity.setOrder(slideRequest.getOrder());
        slideEntity.setOrganizationId(slideRequest.getOrganizationId());
    }

    public SlideResponse slide2ResponseGraphical(SlideEntity slide) {
        SlideResponse slideResponse = new SlideResponse(
                slide.getId(),
                slide.getImageUrl(),
                slide.getText(),
                slide.getOrder(),
                slide.getOrganizationId());
        return slideResponse;
    }

    public List<SlideResponse> slideList2ResponseGraphicalList(List<SlideEntity> slides) {
        List<SlideResponse> slideResponses = new ArrayList<>();
        for (SlideEntity slide : slides) {
            slideResponses.add(slide2ResponseGraphical(slide));
        }
        return slideResponses;
    }
}
