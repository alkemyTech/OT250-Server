package com.alkemy.ong.service;

import com.alkemy.ong.models.request.MemberRequest;
import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.models.response.MemberResponse;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.models.response.PaginationResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface MemberService {
    MemberResponse create (MemberRequest memberRequest) throws IOException;
    void delete (Long id);
    MemberResponse update (Long id, MemberRequest memberRequest) throws IOException;
    PaginationResponse getMemberByPagesAndSize(Optional<Integer> page, Optional<Integer> size);
}
