package com.alkemy.ong.repository;

import com.alkemy.ong.models.entity.SlideEntity;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISlideRepository extends JpaRepository<SlideEntity, Long> {
    List<SlideEntity> findAllByOrderByOrderDesc();


    List<SlideEntity> findAllByOrderByOrderAsc();

    List <SlideEntity> findAllByOrganizationIdOrderByOrderAsc(Long organizationId);

    @Query(value = "Select * FROM slides s where organization_id = :id and deleted = false order by ord asc", nativeQuery = true)
    List<SlideEntity> listSlide(Long id);

}
