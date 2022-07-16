package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.SlideEntity;
import com.alkemy.ong.models.request.SlideRequest;
import com.alkemy.ong.models.response.SlideResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SlideMapper {

    //TODO  private aswS3Service attribute;

    public SlideEntity slideRequest2SlideEntity(SlideRequest slideRequest) throws IOException {
        return SlideEntity.builder().imageUrl(slideRequest.getImageUrl()) //TODO awsS3Service to get the image
                .text(slideRequest.getText())
                .order(slideRequest.getOrder())
                .organizationId(slideRequest.getOrganizationId())
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
}
