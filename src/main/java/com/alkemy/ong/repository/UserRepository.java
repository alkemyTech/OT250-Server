package com.alkemy.ong.repository;

import com.alkemy.ong.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE  u.email = :email")
    public UserEntity findbyEmail(String email);
}
