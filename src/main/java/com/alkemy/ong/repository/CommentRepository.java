package com.alkemy.ong.repository;

import com.alkemy.ong.models.entity.CommentEntity;
import com.alkemy.ong.models.entity.SlideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Query(value =
            "SELECT * " +
            "FROM comment c " +
            "ORDER by comment_date asc;", nativeQuery = true)
    List<CommentEntity> findAllByTimestampAsc();

    @Query(value =
            "SELECT * " +
            "FROM comment c " +
            "WHERE news_id = :newsID " +
            "ORDER by comment_date asc", nativeQuery = true)
    List<CommentEntity> findCommentsByNewsID(Long newsID);
}
