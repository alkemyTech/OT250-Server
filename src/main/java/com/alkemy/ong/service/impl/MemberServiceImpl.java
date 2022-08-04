package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.models.entity.CategoryEntity;
import com.alkemy.ong.models.entity.MemberEntity;
import com.alkemy.ong.models.entity.NewsEntity;
import com.alkemy.ong.models.mapper.MemberMapper;
import com.alkemy.ong.models.request.MemberRequest;
import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.models.response.MemberResponse;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.repository.MemberRepository;
import com.alkemy.ong.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberMapper memberMapper;

    @Override
    public MemberResponse create(MemberRequest memberRequest) throws IOException {
        MemberEntity entity = this.memberMapper.request2Entity(memberRequest);
        MemberEntity entitySave = this.memberRepository.save(entity);
        MemberResponse  memberResponseCreated = this.memberMapper.entity2Response(entitySave);

        return memberResponseCreated;
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Optional<MemberEntity> entity = this.memberRepository.findById(id);

        if (!entity.isPresent()){

            throw new NotFoundException("the id "+id+" does not belong to a news");

        }

        this.memberRepository.delete(entity.get());

    }
    @Override
    public List<MemberResponse> getAllMember() {
        List<MemberEntity> memberList = memberRepository.findAll();// categoryRepository.findAll();
        List<MemberResponse> responseList = memberMapper.entityList2ResponseList(memberList);
        return responseList;
    }

    @Override
    public MemberResponse update(Long id, MemberRequest memberRequest) throws IOException {

        Optional<MemberEntity> entity = this.memberRepository.findById(id);

        if (!entity.isPresent()){

            throw new NotFoundException("the id "+id+" does not belong to a news");
        }

        MemberEntity entityUpdate = this.memberMapper.entityRefreshValues(entity.get(), memberRequest);

        MemberEntity entitySave = this.memberRepository.save(entityUpdate);

        MemberResponse response = this.memberMapper.entity2Response(entitySave);

        return response;


    }
}
