package com.alkemy.ong.repository;

import com.alkemy.ong.models.entity.SlideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISlideRepository extends JpaRepository<SlideEntity, Long> {
}
