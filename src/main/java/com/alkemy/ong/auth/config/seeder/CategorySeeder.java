package com.alkemy.ong.auth.config.seeder;

import com.alkemy.ong.models.entity.CategoryEntity;
import com.alkemy.ong.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class CategorySeeder implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        this.loadCategory();
    }

        private void loadCategory(){

            if (categoryRepository.findAll().isEmpty()){
                categoryRepository.save(new CategoryEntity("catUno", "desc-1", "image-1", new Timestamp(System.currentTimeMillis()), false));
                categoryRepository.save(new CategoryEntity("catDos", "desc-2", "image-2", new Timestamp(System.currentTimeMillis()), false));
                categoryRepository.save(new CategoryEntity("catTres", "desc-3", "image-3", new Timestamp(System.currentTimeMillis()), false));
            }
        }


}
