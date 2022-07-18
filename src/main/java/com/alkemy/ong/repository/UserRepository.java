package com.alkemy.ong.repository;

import com.alkemy.ong.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {

    @Query(value = "SELECT * from users WHERE users.email LIKE %:email%", nativeQuery = true)
   Optional<UserEntity> findByEmail(String email);

    @Query("SELECT u FROM UserEntity u WHERE u.deleted = false")
    List<UserEntity> findBySoftDelete();
}
