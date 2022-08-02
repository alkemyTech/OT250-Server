package com.alkemy.ong.service;


import com.alkemy.ong.models.request.ContactRequest;
import com.alkemy.ong.models.response.ContactResponse;
import java.util.List;
import java.io.IOException;


public interface ContactService {

    boolean isNameOrEmail(ContactRequest request);

    ContactResponse save(ContactRequest request) throws IOException;

    List<ContactResponse> getAll();

}
