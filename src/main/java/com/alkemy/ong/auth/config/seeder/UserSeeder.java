package com.alkemy.ong.auth.config.seeder;

import com.alkemy.ong.models.entity.RoleEntity;
import com.alkemy.ong.models.entity.UserEntity;
import com.alkemy.ong.models.request.UserRequest;
import com.alkemy.ong.repository.RoleRepository;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.service.AuthService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserSeeder implements CommandLineRunner {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;

    @Override

    public void run(String... args) throws Exception {
            this.createUserAdmin();
    }

    private void createUserAdmin() throws IOException {

        if (userRepository.findAll().isEmpty()){


            UserRequest userRequest = new UserRequest("user1", "surname1", "email@mail.com", "admin", "prueba.jpg");

            authService.registerAdmin(userRequest);
        }
    }

}
