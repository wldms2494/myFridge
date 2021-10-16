package com.example.myfridge.dto;

import lombok.Getter;

@Getter
public class IngredientDto {
    private String ingredient;

    public IngredientDto(String ingredient) {
        this.ingredient = ingredient;
    }
}