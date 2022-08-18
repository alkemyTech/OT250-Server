package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.NameOrEmailAreNull;
import com.alkemy.ong.models.entity.ContactEntity;
import com.alkemy.ong.models.mapper.ContactMapper;
import com.alkemy.ong.models.request.ContactRequest;
import com.alkemy.ong.models.response.ContactResponse;
import com.alkemy.ong.models.response.PaginationResponse;
import com.alkemy.ong.repository.ContactRepository;
import com.alkemy.ong.service.ContactService;
import com.alkemy.ong.service.IEmailService;
import com.alkemy.ong.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Optional;


@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private IEmailService emailService;
    @Autowired
    private ContactRepository contactRepository;

    public boolean isNameOrEmail(ContactRequest request) throws NameOrEmailAreNull {

        try{
            if(request.getName().isEmpty() || request.getName() == null ||
                    request.getEmail().isEmpty() || request.getEmail() == null){

                throw new NameOrEmailAreNull("\n name or email are null \n");
            }
        }catch  (NameOrEmailAreNull ex){

            throw new NameOrEmailAreNull ("\n name or email are null \n");
        }

        return false;
    }

    @Override
    public ContactResponse save(ContactRequest request) throws IOException {

        ContactEntity entitySave = contactMapper.request2Entity(request);

        contactRepository.save(entitySave);
        emailService.checkFromRequest(request.getEmail(), "Contact");
        ContactResponse response = contactMapper.entity2Response(entitySave);

        return response;
    }

    @Override
    public List<ContactResponse> getAll() {
        List<ContactEntity> contacts = contactRepository.findAll();
        List <ContactResponse> responses = contactMapper.entityList2Response(contacts);
        return responses;
    }

    @Override
    public PaginationResponse getPage(Optional<Integer> pageNumber, Optional<Integer> size) {
        PaginationUtils pagination = new PaginationUtils(contactRepository, pageNumber, size,
                "/contacts?page=%d&size=%d");
        Page page = pagination.getPage();
        List<ContactEntity> contacts = page.getContent();
        List <ContactResponse> responses = contactMapper.entityList2Response(contacts);
        return PaginationResponse.builder()
                .entities(responses)
                .nextPageURI(pagination.getNext())
                .prevPageURI(pagination.getPrevious())
                .build();
    }
}