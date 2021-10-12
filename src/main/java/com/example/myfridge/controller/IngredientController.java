package com.example.myfridge.controller;

import com.example.myfridge.dto.IngredientDto;
import com.example.myfridge.model.Ingredient;
import com.example.myfridge.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    //냉장고 재료 가져오기
    @GetMapping("/api/recipe")
    public List<Ingredient> getIngredient() {
        return ingredientRepository.findAll();
    }

    //냉장고 재료 츄가하기
    @PostMapping("/api/recipe/search")
    public Ingredient createIngredient(@RequestBody IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient(ingredientDto);

        return ingredientRepository.save(ingredient);

    }

    @GetMapping("/apitest")
    public String apitest() {
        StringBuffer result = new StringBuffer();
        try {
            String urlstr = "http://openapi.foodsafetykorea.go.kr/api/sample/COOKRCP01/json/1/5";

            URL url = new URL(urlstr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));

            String returnLine;
            result.append("<json>");
            while((returnLine = br.readLine()) != null) {
                result.append(returnLine + "\n");
            }
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result + "<json>";
    }
}