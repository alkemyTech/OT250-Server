package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.NameOrEmailAreNull;
import com.alkemy.ong.models.entity.ContactEntity;
import com.alkemy.ong.models.mapper.ContactMapper;
import com.alkemy.ong.models.request.ContactRequest;
import com.alkemy.ong.models.response.ContactResponse;
import com.alkemy.ong.repository.ContactRepository;
import com.alkemy.ong.service.ContactService;
import com.alkemy.ong.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

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


}
