package com.alkemy.ong.auth.config.seeder;

import com.alkemy.ong.models.entity.CategoryEntity;
import com.alkemy.ong.models.entity.NewsEntity;
import com.alkemy.ong.models.entity.OrganizationEntity;
import com.alkemy.ong.models.entity.SlideEntity;
import com.alkemy.ong.models.request.UserRequest;
import com.alkemy.ong.repository.*;
import com.alkemy.ong.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.stream.IntStream;

@Component
public class InitializerSeeder implements CommandLineRunner {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private ISlideRepository slideRepository;
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            this.createUsers(10, "admin");
            this.createUsers(10, "user");
        }
        if (categoryRepository.findAll().isEmpty())
            createCategory();
        if (newsRepository.findAll().isEmpty())
            createNews();
        if (slideRepository.findAll().isEmpty())
            createSlide();
    }

    private void createSlide() {
        if (organizationRepository.findAll().isEmpty())
            createOrganization();
        slideRepository.save(new SlideEntity("imageUlr", "textTest", 1, 1L));
    }

    private void createOrganization() {
        organizationRepository.save(new OrganizationEntity("OrganizationTest", "image.jpg",
                "orgEmail@mail.com", "welcomeText", new Timestamp(System.currentTimeMillis())));
    }

    private void createNews() {
        newsRepository.save(new NewsEntity("NewsTest", "content", "img",
                categoryRepository.getById(6L), new Timestamp(System.currentTimeMillis()), false, "type"));
    }

    private void createCategory() {
        categoryRepository.save(new CategoryEntity( "CategoryTest", "seeder category",
                "img", new Timestamp(System.currentTimeMillis()), false));
    }

    private void createUsers(int users, String userType) {
        final String PASSWORD = "1234";
        if (userType.equalsIgnoreCase("admin")){
            IntStream.range(0, users).forEach(userNumber ->
                createAdmin(userType, PASSWORD, userNumber));
        }
        else{
            IntStream.range(0, users).forEach(userNumber ->
                createNormalUser(userType, PASSWORD, userNumber));
        }
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
