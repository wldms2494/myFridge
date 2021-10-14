package com.example.myfridge.service;

import com.example.myfridge.dto.IngredientDto;
import com.example.myfridge.model.Ingredient;
import com.example.myfridge.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Transactional
    public void delete(IngredientDto ingredientDto) {
        Ingredient test = ingredientRepository.findByIngredient(ingredientDto.getIngredient()).orElseThrow(
                () -> new IllegalArgumentException("재료가 존재하지 않습니다"));
        ingredientRepository.delete(test);
    }
}