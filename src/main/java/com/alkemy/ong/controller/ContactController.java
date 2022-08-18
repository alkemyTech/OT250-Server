package com.alkemy.ong.controller;

import com.alkemy.ong.models.entity.ContactEntity;
import com.alkemy.ong.models.request.ContactRequest;
import com.alkemy.ong.models.response.*;
import com.alkemy.ong.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.bytebuddy.pool.TypePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("contacts")
@Api(value = "Operations related to Contacts", tags = "Contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    @ApiOperation(value = "Create a new Contact", code = 201, response = ContactResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = ContactResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = ApiErrorResponse.class)
    }
    )
    public ResponseEntity<ContactResponse> create(@Valid @RequestBody ContactRequest request) throws IOException {

        ContactResponse response = new ContactResponse();

        if(contactService.isNameOrEmail(request)){

            return ResponseEntity.badRequest().body(response);

        }

        response = contactService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    @ApiOperation(value = "Get the Page number @page of contacts with Size @size from database", code = 200)
    @ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class)
    public ResponseEntity<PaginationResponse> getPage(
            @RequestParam(value = "page", required = false) Optional<Integer> page,
            @RequestParam(value = "size", required = false) Optional<Integer> size) {
            PaginationResponse contacts = contactService.getPage(page, size);
            return ResponseEntity.status(HttpStatus.OK).body(contacts);
    }
}
