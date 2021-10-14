package com.example.myfridge.controller;


import com.example.myfridge.dto.CommentRequestDto;
import com.example.myfridge.model.Comment;
import com.example.myfridge.repository.CommentRepository;
import com.example.myfridge.security.UserDetailsImpl;
import com.example.myfridge.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentService commentService, CommentRepository commentRepository){

        this.commentService = commentService;
        this.commentRepository = commentRepository;
    }

    @PostMapping("/api/comments")
    public void addComment(@RequestBody CommentRequestDto requestDto
                        ){

//        Long userId = userDetails.getUser().getId();
        commentService.creatComment(requestDto);

    }

    @GetMapping("/api/comments")
    public List<Comment> getComment(){
        return commentRepository.findAll();
    }

    @DeleteMapping("/api/comments/{id}")
    public Long delete(@PathVariable Long id) {

        commentRepository.deleteById(id);
        return id;

    }

}
