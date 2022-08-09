package com.alkemy.ong.controller;

import com.alkemy.ong.models.request.OrganizationUpdatelRequest;
import com.alkemy.ong.models.request.OrganizationRequest;
import com.alkemy.ong.models.response.OrganizationResponse;
import com.alkemy.ong.models.response.OrganizationResponseInfo;
import com.alkemy.ong.service.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("organization")
@Api(description ="Organization CRUD" , tags = "Organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;
    @PostMapping
    @ApiOperation(value = "Create Organization", notes = "Allows Admin to insert a new organization")
    @ApiResponses({@ApiResponse(code = 201, message = "Organization created!")})
    public ResponseEntity<OrganizationResponse> save (@RequestBody @Valid OrganizationRequest organization) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationService.save(organization));
    }

    @GetMapping("/public")
    @ApiOperation(value = "Get data from all organizations", notes = "Returns all organizations")
    @ApiResponses({@ApiResponse(code = 200, message = "Return all saved organizations")})
    public ResponseEntity<List<OrganizationResponseInfo>> dataOrganization(){
        List<OrganizationResponseInfo>responses = organizationService.GetInfo();
        return ResponseEntity.ok().body(responses);
    }



    @PutMapping("/{id}")
    @ApiOperation(value = "Update Organization By ID", notes = "Allows Admin to update an existing organization by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Organization updated!"),
            @ApiResponse(code = 404, message = "The inserted ID does not belong to a organization"),})
    public ResponseEntity<Object> update(@PathVariable("id") @Valid @NotNull Long id, @Valid @RequestBody OrganizationRequest request){
        OrganizationResponse response = null;
        try {
           response = organizationService.update(id, request);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "Update an organization data by ID", notes = "Allows the administrator to update" +
                  " an existing organization data by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Organization updated!"),
            @ApiResponse(code = 404, message = "The inserted ID does not belong to a organization"),})
    public ResponseEntity<OrganizationResponse> updateOrg(
            @PathVariable("id") @Valid @NotNull Long id,
            @RequestBody @Valid OrganizationUpdatelRequest request) throws IOException {
        OrganizationResponse update = organizationService.basicUpdate(id, request);
        return ResponseEntity.ok().body(update);
    }


}
