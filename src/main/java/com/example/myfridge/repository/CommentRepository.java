package com.example.myfridge.repository;

import com.example.myfridge.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByIdOrderByCreatedAt(Long id);
}
