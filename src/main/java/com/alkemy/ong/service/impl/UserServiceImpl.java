package com.alkemy.ong.service.impl;

import com.alkemy.ong.models.request.AuthRequest;
import com.alkemy.ong.models.request.UserRequest;
import com.alkemy.ong.models.response.AuthResponse;
import com.alkemy.ong.models.response.UserDetailsResponse;
import com.alkemy.ong.models.response.UserResponse;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;

public class UserServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

   // @Autowired
   // private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(UserRequest userRequest) throws UsernameNotFoundException, IOException {
        return null;
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        return null;
    }

    @Override
    public UserDetailsResponse getPersonalInformation(String token) {
        return null;
    }
}
