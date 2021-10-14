package com.example.myfridge.repository;

import com.example.myfridge.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
//    Optional<Comment> findByRecipeTitle(String recipeTitle);
}
