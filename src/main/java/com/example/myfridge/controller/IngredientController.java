package com.example.myfridge.controller;



import com.example.myfridge.dto.IngredientDto;
import com.example.myfridge.model.Ingredient;
import com.example.myfridge.repository.IngredientRepository;

import com.example.myfridge.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class IngredientController {

    private final IngredientRepository ingredientRepository;
    private final IngredientService ingredientService;


    //냉장고 재료 가져오기
    @GetMapping("/api/recipe")
    public List<Ingredient> getIngredient() {
        return ingredientRepository.findAll();
    }


    //냉장고 재료 추가하기
    @PostMapping("/api/recipe")
    public Ingredient createIngredient(@RequestBody IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient(ingredientDto);

        return ingredientRepository.save(ingredient);
    }

    //재료 선택 시 매뉴 data추출
    @GetMapping("/api/recipe/{ingredient}")
    public List<String> onlymenu(@PathVariable String ingredient) {
        return ingredientService.findmenu(ingredient);
    }


    //메뉴 선택 시 레시피 추출
    @GetMapping("/api/recipe/menu/{recipe}")
    public List<String> rcpmunaul(@PathVariable String recipe){
        return ingredientService.menurecipe(recipe);
    }

    //냉장고 재료 삭제하기
    @DeleteMapping("/api/recipe")
    public String deleteIngredient(@RequestBody IngredientDto ingredientDto) {
        ingredientService.delete(ingredientDto);

        return "삭제완료";
    }



}