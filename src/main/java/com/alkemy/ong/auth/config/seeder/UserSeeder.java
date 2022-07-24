package com.alkemy.ong.auth.config.seeder;

import com.alkemy.ong.models.entity.RoleEntity;
import com.alkemy.ong.models.entity.UserEntity;
import com.alkemy.ong.repository.RoleRepository;
import com.alkemy.ong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserSeeder implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
            createUserAdmin();
    }

    private void createUserAdmin() {
        if (userRepository.findAll().isEmpty())
            roleRepository.save(new RoleEntity(1L,"ADMIN", "admin role", null));
            Set<RoleEntity> roles = (Set<RoleEntity>) roleRepository.findAll();
            userRepository.save(new UserEntity(1L, "User1", "Subname",
                    "email@email.com", "photo.png", "admin", roles,
                    null, false));
    }
}
