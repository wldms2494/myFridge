package com.example.myfridge.controller;


import com.example.myfridge.dto.CommentRequestDto;
import com.example.myfridge.model.Comment;
import com.example.myfridge.repository.CommentRepository;
import com.example.myfridge.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //댓글 등록
    @PostMapping("/api/comments")
    public void addComment(@RequestBody CommentRequestDto requestDto){

        commentService.creatComment(requestDto);

    }

    //댓글 조회
    @GetMapping("/api/comments")
    public List<Comment> getComment(){
        return commentRepository.findAll();
    }


    //댓글 수정
    @PutMapping ("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        commentService.update(id, requestDto);
        return id;
    }

    //댓글 삭제
    @DeleteMapping("/api/comments/{id}")
    public Long delete(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;

    }



}
