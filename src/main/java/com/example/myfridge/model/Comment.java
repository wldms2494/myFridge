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

    @Column
    private String recipeTitle;

    @Column
    private int star;

    @Column
    private String username;


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
        this.username = requestDto.getUsername();

    }

    //update메소드 추가요
    public void update(CommentRequestDto requestDto){
        this.content = requestDto.getContent();
//        this.recipeTitle = requestDto.getRecipeTitle();
//        this.star = requestDto.getStar();


    }

    //xss방지 생성자 만듬
    public Comment (CommentRequestDto requestDto, String content) {
        this.recipeTitle = requestDto.getRecipeTitle();
        this.username = requestDto.getUsername();
        this.content = content;

    }

}



