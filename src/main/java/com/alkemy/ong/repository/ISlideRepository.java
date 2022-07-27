package com.alkemy.ong.repository;

import com.alkemy.ong.models.entity.SlideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISlideRepository extends JpaRepository<SlideEntity, Long> {
    List<SlideEntity> findAllByOrderByOrderDesc();


    List<SlideEntity> findAllByOrderByOrderAsc();

    List <SlideEntity> findAllByOrganizationIdOrderByOrderAsc(Long organanizationId);
}
