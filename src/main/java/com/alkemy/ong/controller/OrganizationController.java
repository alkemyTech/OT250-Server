package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.OrganizationRequest;
import com.alkemy.ong.models.response.OrganizationResponse;
import com.alkemy.ong.models.response.OrganizationResponseInfo;
import com.alkemy.ong.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;
    @PostMapping
    public ResponseEntity<OrganizationResponse> save (@RequestBody @Valid OrganizationRequest organization){
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationService.save(organization));
    }

    @GetMapping("/public")
    public ResponseEntity<List<OrganizationResponseInfo>> dataOrganization(){
        List<OrganizationResponseInfo>responses = organizationService.GetInfo();
        return ResponseEntity.ok().body(responses);
    }



    @PutMapping("/public/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") @Valid @NotNull Long id, @Valid @RequestBody OrganizationRequest request){
        OrganizationResponse response = null;
        try {
           response = organizationService.update(id, request);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
}
