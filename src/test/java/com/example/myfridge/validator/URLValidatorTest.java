package com.example.myfridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URLValidatorTest {

    @Test
    @DisplayName("URL 형태 :정상")
    void urlvalidator1() {
        //given
        String url = "http://openapi.foodsafetykorea.go.kr/api/1e28eb3d73944ce09097/COOKRCP01/json/0/1/" ;

        //when
        boolean isValid = URLValidator.isValidUrl(url);
        //then
       assertTrue(isValid);
    }

    @Test
    @DisplayName("URL이 한글일 때")
    void urlvalidator2() {
        //given
        String url = "그냥 한글~";
        //when
        boolean isvalid = URLValidator.isValidUrl(url);
        //then
        assertFalse(isvalid);
    }

    @Test
    @DisplayName("URL이 null 일 때")
    void urlvalidator3() {
        //given
        String url = "";
        //when
        boolean isvalid = URLValidator.isValidUrl(url);
        //then
        assertFalse(isvalid);
    }
    @Test
    @DisplayName("://이 없을 때")
    void urlvalidator4() {
        //given
        String url = "httpopenapi.foodsafetykorea.go.kr/api/1e28eb3d73944ce09097/COOKRCP01/json/0/1/";
        //when
        boolean isvalid = URLValidator.isValidUrl(url);
        //then
        assertFalse(isvalid);
    }
}