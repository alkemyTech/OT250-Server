package com.alkemy.ong.service;


import com.alkemy.ong.models.request.ContactRequest;
import com.alkemy.ong.models.response.ContactResponse;
import com.alkemy.ong.models.response.PaginationResponse;

import java.util.List;
import java.io.IOException;
import java.util.Optional;


public interface ContactService {

    boolean isNameOrEmail(ContactRequest request);

    ContactResponse save(ContactRequest request) throws IOException;

    List<ContactResponse> getAll();

    PaginationResponse getPage(Optional<Integer> page, Optional<Integer> size);

}
