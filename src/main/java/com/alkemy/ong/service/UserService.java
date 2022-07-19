package com.alkemy.ong.service;

import com.alkemy.ong.models.request.UserUpdateRequest;
import com.alkemy.ong.models.response.UserDetailsResponse;
import com.alkemy.ong.models.response.UsersPaginationResponse;

import java.util.List;

public interface UserService {

    //void deleteUser(Long id);
    void updateUser(Long id, UserUpdateRequest request);
    List<UserDetailsResponse> getUsers();
    UsersPaginationResponse getPaginationUsers(Integer page);

    void deleteUser(Long id);

}
