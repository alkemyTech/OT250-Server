package com.alkemy.ong.models.mapper;

import com.alkemy.ong.models.entity.RoleEntity;
import com.alkemy.ong.models.entity.UserEntity;
import com.alkemy.ong.models.request.UserRequest;
import com.alkemy.ong.models.response.UserDetailsResponse;
import com.alkemy.ong.models.response.UserResponse;
import com.alkemy.ong.models.response.UsersPaginationResponse;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserEntity toUserEntity(UserRequest userRequest, Set<RoleEntity> roles) {
        return UserEntity.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .roleId(roles)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
    }

    public UserResponse toUserResponse(UserEntity userEntity, String token) {
        return UserResponse.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .token(token)
                .build();
    }

    public UserDetailsResponse userToUserDetail(UserEntity update) {
        return UserDetailsResponse.builder()
                .firstName(update.getFirstName())
                .lastName(update.getLastName())
                .email(update.getEmail())
                .photo(update.getPhoto())
                .timestamp(update.getTimestamp())
                .build();
    }

    public List<UserDetailsResponse> usersToUserDetailsList(List<UserEntity> users) {
        List<UserDetailsResponse> list = new ArrayList<>();

        for(UserEntity user : users) {
            list.add( userToUserDetail(user) );
        }

        return list;
    }

    public UsersPaginationResponse toUsersPaginationResponse(List<UserEntity> userEntities, String prev, String nxt) {
        List<UserDetailsResponse> userList = userEntities.stream().map( c ->
                userToUserDetail(c)).collect(Collectors.toList());
        return UsersPaginationResponse.builder()
                .users(userList)
                .prev(prev)
                .nxt(nxt)
                .build();

    }

}
