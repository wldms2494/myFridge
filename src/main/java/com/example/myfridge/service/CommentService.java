package com.example.myfridge.service;


import com.example.myfridge.dto.CommentRequestDto;
import com.example.myfridge.model.Comment;
import com.example.myfridge.model.Ingredient;
import com.example.myfridge.repository.CommentRepository;
import com.example.myfridge.repository.IngredientRepository;
import com.example.myfridge.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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


        //댓글 생성
        @Transactional
         public Comment creatComment(CommentRequestDto requestDto) {

        String commentCheck = requestDto.getContent();
        if(commentCheck.contains("script")||commentCheck.contains("<")||commentCheck.contains(">")){

            Comment comment = new Comment(requestDto, "뭐하시는겁니까!!!");
            commentRepository.save(comment);
            return comment;
        }
        Comment comment = new Comment (requestDto);
        commentRepository.save(comment);
        return comment;

    }
        //댓글 수정
        @Transactional //디비에 진짜 가야해...!!!확인사살
        public void update(Long id, CommentRequestDto requestDto) {
            Comment comment = commentRepository.findById(id).orElseThrow(
                    () -> new NullPointerException("아이디가 존재하지 않습니다.")
            );
            comment.update(requestDto);
        }
    }
