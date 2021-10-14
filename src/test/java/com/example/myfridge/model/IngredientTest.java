package com.example.myfridge.model;

import com.example.myfridge.dto.IngredientDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    @DisplayName("정상 케이스")
    void createIngredient() {

        //given
        String ingredient = "당근";

        IngredientDto ingredientDto = new IngredientDto(ingredient);

        //when
        Ingredient ingredient1 = new Ingredient(ingredientDto);

        //then
        assertNull(ingredient1.getId());
        assertEquals(ingredient, ingredient1.getIngredient());

    }

}