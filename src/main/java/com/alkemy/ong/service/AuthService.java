package com.alkemy.ong.service;

import com.alkemy.ong.models.request.AuthRequest;
import com.alkemy.ong.models.request.UserRequest;
import com.alkemy.ong.models.response.AuthResponse;
import com.alkemy.ong.models.response.UserDetailsResponse;
import com.alkemy.ong.models.response.UserResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.IOException;

public interface AuthService {
    UserResponse register(UserRequest userRequest) throws UsernameNotFoundException, IOException;
    AuthResponse login(AuthRequest authRequest);
    UserDetailsResponse getPersonalInformation(String token) throws IOException;
    void registerAdmin(UserRequest userRequest) throws IOException;
}
