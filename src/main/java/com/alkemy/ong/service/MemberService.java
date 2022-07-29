package com.alkemy.ong.service;

import com.alkemy.ong.models.request.MemberRequest;
import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.models.response.MemberResponse;

import java.io.IOException;
import java.util.List;

public interface MemberService {
    MemberResponse create (MemberRequest memberRequest) throws IOException;
    void delete (Long id);
    List<MemberResponse> getAllMember();
}
