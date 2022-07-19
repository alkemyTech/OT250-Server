package com.alkemy.ong.service.impl;

import com.alkemy.ong.models.entity.UserEntity;
import com.alkemy.ong.models.mapper.UserMapper;
import com.alkemy.ong.models.request.AuthRequest;
import com.alkemy.ong.models.request.UserRequest;
import com.alkemy.ong.models.request.UserUpdateRequest;
import com.alkemy.ong.models.response.AuthResponse;
import com.alkemy.ong.models.response.UserDetailsResponse;
import com.alkemy.ong.models.response.UserResponse;
import com.alkemy.ong.models.response.UsersPaginationResponse;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.service.AuthService;
import com.alkemy.ong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserResponse register(UserRequest userRequest) throws UsernameNotFoundException, IOException {
        return null;
    }


    public AuthResponse login(AuthRequest authRequest) {
        return null;
    }


    public UserDetailsResponse getPersonalInformation(String token) {
        return null;
    }

    @Override
    public void updateUser(Long id, UserUpdateRequest request) {
        UserEntity user = getById(id);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhoto(request.getPhoto());
        userRepository.save(user);

    }

    private UserEntity getById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public List<UserDetailsResponse> getUsers(){
        List<UserEntity> users = userRepository.findAll();
        List<UserDetailsResponse> Response = userMapper.usersToUserDetailsList(users);
        return Response;

    }

    @Override
    public UsersPaginationResponse getPaginationUsers(Integer page) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity user = getById(id);
        userRepository.deleteById(user.getId());

    }
}
