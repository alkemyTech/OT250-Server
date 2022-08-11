package com.alkemy.ong.controller;


import com.alkemy.ong.models.request.MemberRequest;
import com.alkemy.ong.models.request.NewsRequest;
import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.models.response.MemberResponse;
import com.alkemy.ong.models.response.NewsResponse;
import com.alkemy.ong.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponse> createMember(@Valid @RequestBody MemberRequest memberRequest) throws IOException {

        MemberResponse memberResponseCreate = memberService.create(memberRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(memberResponseCreate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNews(@Valid @PathVariable Long id) {

        this.memberService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<MemberResponse> memberList = memberService.getAllMember();
        return ResponseEntity.ok().body(memberList);
    }

    @PutMapping("{id}")
    public ResponseEntity<MemberResponse> updateMember(@Valid @PathVariable Long id,
                                                       @RequestBody MemberRequest memberRequest) throws IOException {

        MemberResponse memberResponse = this.memberService.update(id, memberRequest);

        return ResponseEntity.status(HttpStatus.OK).body(memberResponse);

    }

}
