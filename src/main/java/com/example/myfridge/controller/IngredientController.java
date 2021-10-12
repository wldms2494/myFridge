package com.example.myfridge.controller;

import com.example.myfridge.dto.IngredientDto;
import com.example.myfridge.model.Ingredient;
import com.example.myfridge.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
    @PostMapping("/api/recipe")
    public Ingredient createIngredient(@RequestBody IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient(ingredientDto);

        return ingredientRepository.save(ingredient);
    }

    @GetMapping("/apitest")
    public List<String> apitest() {
        StringBuffer result = new StringBuffer();

        ArrayList<String> list = new ArrayList<>();

        try {
            String urlstr = "http://openapi.foodsafetykorea.go.kr/api/1e28eb3d73944ce09097/COOKRCP01/json/6/10/";


            URL url = new URL(urlstr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));

            String returnLine;
            while((returnLine = br.readLine()) != null) {
                result.append(returnLine);
            }

            urlConnection.disconnect();

            JSONObject jObj;
            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObj = (JSONObject) jsonParser.parse(result.toString());

            JSONObject parseresponse = (JSONObject) jsonObj.get("COOKRCP01");

            JSONArray array = (JSONArray) parseresponse.get("row");

            for (Object o : array) {
                jObj = (JSONObject) o;

                String name = jObj.get("RCP_NM").toString();
                list.add(name);
                System.out.println(name);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return list;
    }

}
