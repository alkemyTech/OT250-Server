package com.alkemy.ong.auth.config.seeder;

import com.alkemy.ong.models.entity.ActivityEntity;
import com.alkemy.ong.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ActivitySeeder implements CommandLineRunner {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void run(String... args) throws Exception {
        this.loadActivity();

    }

    private void loadActivity() { 

        if(activityRepository.findAll().isEmpty()){
            activityRepository.save(new ActivityEntity("act-1","conte-1", "image-1",new Timestamp(System.currentTimeMillis()), false));
            activityRepository.save(new ActivityEntity("act-2","conte-2", "image-2",new Timestamp(System.currentTimeMillis()), false));
            activityRepository.save(new ActivityEntity("act-3","conte-3", "image-3",new Timestamp(System.currentTimeMillis()), false));
            activityRepository.save(new ActivityEntity("act-4","conte-4", "image-4",new Timestamp(System.currentTimeMillis()), false));
            activityRepository.save(new ActivityEntity("act-5","conte-5", "image-5",new Timestamp(System.currentTimeMillis()), false));
        }


    }
}
