package com.example.myfridge.dto;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CommentRequestDto {

    String content;
    String recipeTitle;
    int star;
}
