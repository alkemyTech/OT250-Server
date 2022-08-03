package com.alkemy.ong.controller;

import com.alkemy.ong.models.entity.ContactEntity;
import com.alkemy.ong.models.request.ContactRequest;
import com.alkemy.ong.models.response.ContactResponse;
import com.alkemy.ong.models.response.UserDetailsResponse;
import com.alkemy.ong.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.io.IOException;

@RestController
@RequestMapping("contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactResponse> create(@Valid @RequestBody ContactRequest request) throws IOException {

        ContactResponse response = new ContactResponse();

        if(contactService.isNameOrEmail(request)){

            return ResponseEntity.badRequest().body(response);

        }

        response = contactService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll(){
        List<ContactResponse> contacts = contactService.getAll();
        return ResponseEntity.ok().body(contacts);
    }

}
