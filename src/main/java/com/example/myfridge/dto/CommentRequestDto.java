package com.example.myfridge.dto;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CommentRequestDto {

   private String content;
   private String recipeTitle;
   private int star;

   //추가부분
   private String username;
}
