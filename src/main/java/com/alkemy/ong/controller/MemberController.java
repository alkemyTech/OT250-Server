package com.alkemy.ong.controller;


import com.alkemy.ong.models.request.MemberRequest;
import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.models.response.MemberResponse;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.models.response.PaginationResponse;
import com.alkemy.ong.service.MemberService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("members")
@Api(description = "Member Crud", tags = "Members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    @ApiOperation(value = "Create Member", notes = "Allows an user to insert a member")
    @ApiResponses({@ApiResponse(code = 201, message = "Member created!")})
    public ResponseEntity<MemberResponse> createMember(@Valid @RequestBody MemberRequest memberRequest) throws IOException {

        MemberResponse memberResponseCreate = memberService.create(memberRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(memberResponseCreate);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Soft Delete Member By ID", notes = "Allows Admin to delete news by ID")
    @ApiResponses({@ApiResponse(code = 204, message = "Member soft deleted!"),
            @ApiResponse(code = 404, message = "The inserted ID does not belong to a member"),})
    public ResponseEntity<Void> deleteMember(@Valid @PathVariable @ApiParam(name = "id",
                                            type = "Long",
                                            value = "ID of the member requested",
                                            example = "1",
                                            required = true) Long id) {

        this.memberService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    @ApiOperation(value = "Get all Members", notes = "Allows Admin to get all the existing members")
    public ResponseEntity<PaginationResponse> getAllMembers(@RequestParam(value = "page", required = false) Optional<Integer> page,
                                                            @RequestParam(value = "size", required = false) Optional<Integer> size) {
        return new ResponseEntity<>(memberService.getMemberByPagesAndSize(page, size), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Update Member By ID", notes = "Allows Admin to update an existing member by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Member updated!"),
            @ApiResponse(code = 404, message = "The inserted ID does not belong to a member"),})
    public ResponseEntity<MemberResponse> updateMember(@Valid @PathVariable @ApiParam(
                                            name = "id",
                                            type = "Long",
                                            value = "ID of the news requested",
                                            example = "1",
                                            required = true) Long id,
                                            @RequestBody @ApiParam(
                                                    name = "New Member",
                                                    value = "Member to save",
                                                    required = true) MemberRequest memberRequest) throws IOException {

        MemberResponse memberResponse = this.memberService.update(id, memberRequest);

        return ResponseEntity.status(HttpStatus.OK).body(memberResponse);

    }

}
