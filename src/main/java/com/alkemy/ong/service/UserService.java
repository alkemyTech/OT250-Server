package com.alkemy.ong.service;

import com.alkemy.ong.models.request.UserUpdateRequest;
import com.alkemy.ong.models.response.UserDetailsResponse;

import java.util.List;

public interface UserService {

    UserDetailsResponse updateBasicUser(UserUpdateRequest request, String token);
    UserDetailsResponse updateUserForAdmin(Long id, UserUpdateRequest request);
    List<UserDetailsResponse> getUsers();

    //UsersPaginationResponse getPaginationUsers(Integer page);
    void deleteUserForAdmin(Long id);

    void deleteBasicUser(String token);

}
