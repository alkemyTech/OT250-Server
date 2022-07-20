package com.alkemy.ong.service;

import com.alkemy.ong.models.request.UserUpdateRequest;
import com.alkemy.ong.models.response.UserDetailsResponse;

import java.util.List;

public interface UserService {

    UserDetailsResponse updateUser(Long id, UserUpdateRequest request);
    List<UserDetailsResponse> getUsers();

    //UsersPaginationResponse getPaginationUsers(Integer page);
    void deleteUser(Long id);

}
