package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.MemberEntity;
import com.alkemy.ong.models.request.MemberRequest;
import com.alkemy.ong.models.response.MemberResponse;
import com.alkemy.ong.service.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemberMapper {

    @Autowired
    private AwsService awsService;

    public MemberEntity request2Entity (MemberRequest memberRequest) throws IOException {

        return MemberEntity.builder()
                .name(memberRequest.getName())
                .description(memberRequest.getDescription())
                .image(awsService.uploadFileFromBase64(memberRequest.getImage()))
                .facebookUrl(memberRequest.getFacebookUrl())
                .instagramUrl(memberRequest.getInstagramUrl())
                .linkedinUrl(memberRequest.getLinkedinUrl())
                .build();

    }

    public MemberResponse entity2Response (MemberEntity memberEntity){

        return MemberResponse.builder()
                .name(memberEntity.getName())
                .description(memberEntity.getDescription())
                .image(memberEntity.getImage())
                .facebookUrl(memberEntity.getFacebookUrl())
                .instagramUrl(memberEntity.getInstagramUrl())
                .linkedinUrl(memberEntity.getLinkedinUrl())
                .timeStamp(memberEntity.getTimeStamp())
                .build();
    }

    public List<MemberResponse> entityList2ResponseList (List<MemberEntity> entityList){

        List<MemberResponse> responseList= new ArrayList<>();
        for (MemberEntity entity: entityList) {

            responseList.add(entity2Response(entity));

        }

        return responseList;
    }




}
