package com.example.myfridge.model;

import com.example.myfridge.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String content;

//    @Column(nullable = false)
//    private Long userId;

    @Column(nullable = false)
    private String recipeTitle;

    @Column(nullable = false)
    private int star;


//
//    public Comment(String content, Long userId, String recipeTitle) {
//        this.content = content;
//        this.userId = userId;
//        this.recipeTitle = recipeTitle;
//
//    }

//    public Comment(CommentRequestDto requestDto, Long userId){
//
//        this.content = requestDto.getContent();
//        this.userId = userId;
//        this.recipeTitle = requestDto.getRecipeTitle();
//
//
//    }

    public Comment(CommentRequestDto requestDto){
        this.content = requestDto.getContent();
        this.recipeTitle = requestDto.getRecipeTitle();
        this.star = requestDto.getStar();

    }
//
//    public void addComment(Comment comment){
//        this.commentList.add(comment);
//    }

}



