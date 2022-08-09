package com.alkemy.ong.auth.config.seeder;

import com.alkemy.ong.models.request.UserRequest;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.stream.Stream;


@Component
public class UserSeeder implements CommandLineRunner {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;

    @Override

    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            this.createUsers(10, "admin");
            this.createUsers(10, "user");
        }
    }

    private void createUsers(int users, String userType) throws IOException {
            createUsersAux(users, userType);
    }

    private void createUsersAux(int users, String userType) {
        final String PASSWORD = "1234";
        Stream.iterate(0, n -> n + 1).limit(users)
                .forEach(userNumber -> {
                    if (userType.equalsIgnoreCase("admin"))
                        createAdmin(userType, PASSWORD, userNumber);
                    else
                        createNormalUser(userType, PASSWORD, userNumber);
                });
    }

    private void createNormalUser(String userType, String PASSWORD, Integer userNumber) {
        try {
            authService.register(new UserRequest(userType + userNumber, userType + userNumber,
                    "email"+ userType + userNumber +"@mail.com", PASSWORD, userType +"Photo"+ userNumber +".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createAdmin(String userType, String PASSWORD, Integer userNumber) {
        try {
            authService.registerAdmin(new UserRequest(userType + userNumber, userType + userNumber,
                    "email"+ userType + userNumber +"@mail.com", PASSWORD, userType +"Photo"+ userNumber +".png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
