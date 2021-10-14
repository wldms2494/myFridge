package com.example.myfridge.service;


import com.example.myfridge.dto.CommentRequestDto;
import com.example.myfridge.model.Comment;
import com.example.myfridge.model.Ingredient;
import com.example.myfridge.repository.CommentRepository;
import com.example.myfridge.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final IngredientRepository ingredientRepository;

    public CommentService(CommentRepository commentRepository, IngredientRepository ingredientRepository) {
        this.commentRepository =commentRepository;
        this.ingredientRepository = ingredientRepository;
            }

        @Transactional
         public Comment creatComment(CommentRequestDto requestDto) {

        Comment comment = new Comment(requestDto);

        commentRepository.save(comment);
//        Comment comment2 = commentRepository.findByRecipeTitle(comment.getRecipeTitle()).orElse(null);;
//        comment.addComment(comment2);

        return comment;

    }
}
