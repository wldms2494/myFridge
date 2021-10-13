package com.example.myfridge.controller;



import com.example.myfridge.dto.IngredientDto;
import com.example.myfridge.model.Ingredient;
import com.example.myfridge.repository.IngredientRepository;
import com.example.myfridge.service.Ingredientservice;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.*;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class IngredientController {

    private final IngredientRepository ingredientRepository;
    private final Ingredientservice ingredientservice;

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


    //냉장고 재료 삭제하기
    @DeleteMapping("/api/recipe")
    public String deleteIngredient(@RequestBody IngredientDto ingredientDto) {
        ingredientservice.delete(ingredientDto);

        return "삭제완료";
    }


    // 재료 선택 시 메뉴 data 추출
    @GetMapping("/api/recipe/{id}")
    public List<String> onlymenu(@PathVariable Long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("ID가 존재하지 않습니다")
        );
        String query = ingredient.getIngredient();

        StringBuffer result = new StringBuffer();
        System.out.println(query);


        ArrayList<String> list = new ArrayList<>();

        try {
            String urlstr = "http://openapi.foodsafetykorea.go.kr/api/1e28eb3d73944ce09097/COOKRCP01/json/6/10/RCP_PARTS_DTLS="+query  ;


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
                String img = jObj.get("ATT_FILE_NO_MAIN").toString();

                list.add(name);
                list.add(img);
            }
            System.out.println(list);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //메뉴 선택 시 레시피 추출
    @GetMapping("/api/recipe/menu/{query}")
    public List<String> rcpmunaul(@PathVariable String query) {
        StringBuffer result = new StringBuffer();

        String finaltest= "";

        if(query.contains(" ")) {
            String result1 = query.replaceAll("\\s", "_");
            finaltest = result1;
            System.out.println(finaltest);
        } else {
            finaltest = query;
        }
        ArrayList<String> list = new ArrayList<>();

        try {
            String urlstr = "http://openapi.foodsafetykorea.go.kr/api/1e28eb3d73944ce09097/COOKRCP01/json/0/1/RCP_NM="+finaltest;


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
                String img = jObj.get("ATT_FILE_NO_MAIN").toString();
                String menual1 = jObj.get("MANUAL01").toString();
                String menual2 = jObj.get("MANUAL02").toString();
                String menual3 = jObj.get("MANUAL03").toString();
                String menual4 = jObj.get("MANUAL04").toString();
                String menual5 = jObj.get("MANUAL05").toString();
                String menual6 = jObj.get("MANUAL06").toString();
                String menual7 = jObj.get("MANUAL07").toString();
                String menual8 = jObj.get("MANUAL08").toString();
                String menual9 = jObj.get("MANUAL09").toString();

                String ingredient = jObj.get("RCP_PARTS_DTLS").toString();

                list.add(name);
                list.add(img);
                list.add(ingredient);
                list.add(menual1);
                list.add(menual2);
                list.add(menual3);
                list.add(menual4);
                list.add(menual5);
                list.add(menual6);
                list.add(menual7);
                list.add(menual8);
                list.add(menual9);
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}