package com.alkemy.ong.repository;

import com.alkemy.ong.models.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository <RoleEntity, Long> {
    Set<RoleEntity> findByName(String name);
}
