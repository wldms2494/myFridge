package com.example.myfridge.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    public void init(String jsondata) throws ParseException {
        JSONObject jObj;
        JSONParser jsonParser = new JSONParser();

        JSONObject jsonObj = (JSONObject) jsonParser.parse(jsondata);

        JSONObject parseresponse = (JSONObject) jsonObj.get("COOKRCP01");

        JSONArray array = (JSONArray) parseresponse.get("row");

        for (int i = 0; i < array.size(); i++) {
            jObj = (JSONObject) array.get(i);

            String name = jObj.get("RCP_NM").toString();
            System.out.println(name);
        }


    }
}
