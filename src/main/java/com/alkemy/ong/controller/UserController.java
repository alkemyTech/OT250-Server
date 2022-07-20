package com.alkemy.ong.controller;


import com.alkemy.ong.models.request.UserUpdateRequest;
import com.alkemy.ong.models.response.UserDetailsResponse;
import com.alkemy.ong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDetailsResponse>> getAll(){
        List<UserDetailsResponse> users = userService.getUsers();
        return ResponseEntity.ok().body(users);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDetailsResponse> updateUser(@PathVariable("id") @Valid @NotNull Long id,
                                           @RequestBody @Valid UserUpdateRequest request){
       UserDetailsResponse update = userService.updateUser(id, request);
        return ResponseEntity.ok().body(update);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")@Valid @NotNull Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
