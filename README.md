My Fridge๐ฅข
======================
์๋น์ค ์ฃผ์ : http://eternalclash.shop.s3-website.ap-northeast-2.amazonaws.com/

์์ด์ด ํ๋ ์
============
[์์ด์ดํ๋ ์](https://www.notion.so/16-ab85549ccb3d452ba6267dde8448d993).

๊ฐ๋ฐ ๋ชฉํ
======================
- [x] : ๋๊ธ CRUD
- [x] : ๊ณต๊ณตAPI๋ฅผ ํตํ ๊ฒ์ ๊ธฐ๋ฅ
- [x] : ํ์๊ฐ์ & Spring์์์ JWT ๋ฐฉ์์ ๋ก๊ทธ์ธ
- [x] : ์๋ก ๋ค๋ฅธ ๊ฐ๋ฐํ๊ฒฝ ์์์ ์ฐ๋(CORS)


Developers๐
================
์ด ๊ฐ๋ฐ ์ธ์ : 6๋ช  
-Front end๐ :์ด์์ฐฝ, ์ฃผ์ฌ์ผ, ์ด์งํ  
-Back end๐ : ์ก์ง์, ์ด๋ค๋ด, ๊น์ ๊ฒธ  

๊ฐ์
=====================

*๊ฐ๋ฐ ๊ธฐ๊ฐ v: 2021-10-11 ~ 2021-10-16  
*์คํ : React / Spring  


*์ฃผ์ ๊ธฐ๋ฅ   

  - ๊ณต๊ณต๋ฐ์ดํฐ๋ฅผ ํตํ ๋ ์ํผ ๊ฒ์
  - ์ฌ๋ฃ ์ถ๊ฐ์ ์ญ์ฒด๋ฅผ ํตํ ๋์ฅ๊ณ  ์ฌ๋ฃ ๊ด๋ฆฌ
  - ๋ ์ํผ ํ๋๋ฅผ ์ ํํ๊ณ  ๊ฑฐ๊ธฐ์ ๋๊ธ CRUD 
  - ๋๊ธ๊ณผ ํจ๊ป ๋ณ์  ์ฒดํฌ
  - ํ์๊ฐ์ & Sprig ์์์ JWT๋ฐฉ์์ ๋ก๊ทธ์ธ



์ฌ์ฉ ๊ธฐ์ 
====================
`๋ฐฑ์ค๋`
- Java 8
- SpringBoot 
- Gradle
- JPA
- MySQL

`ํ๋ก ํธ์ค๋`  

-React

`deploy`  
-AWS EC2  
-AWS RDS


โญ๏ธAPI์ค๊ณโญ๏ธ
=======================

**ํ์๊ฐ์**

๊ธฐ๋ฅ|METHOD|APIURL|REQUEST|RESPONSE|
-----------------|------------|-----------|------------|-------------|
ํ์๊ฐ์|GET|/user/signup| - |ํ์๊ฐ์ Form Page|
ํ์๊ฐ์|POST|/user/signup|{"username" : "์์ด๋","password" : "123","email" : "a@gmail.com}| redirect/user/login |
๋ก๊ทธ์ธ|POST|/user/login|{"username" : "์์ด๋","password" : "123"} | {"username" : "์์ด๋" , "token":"eyJhbGciOiJIUzI1NiJ9."}|
๋ก๊ทธ์ธ|GET|/user/login| - || ๋ก๊ทธ์ธ Form Page |


**COMMENT**

|๊ธฐ๋ฅ|METHOD|APIURL|REQUEST|RESPONSE|
|---------|-------|------|-------|--------|
|๋๊ธ ์กฐํ|GET|/api/comments| - |["username" : "ํ๊ธธ๋, "content" : "๋ด์ฉ์๋๋ค]|
|๋๊ธ ๋ฑ๋ก|POST|/api/comments|{"content" : "๋ด์ฉ","recipeTitle" : "๋จํธ๋ฐ ์ผ์ผ๋ฐฅ","star" :4}| -|
|๋๊ธ ์์ |PUT|/api/comments/{id}| {"cotent" : "์์ ํ ๋ด์ฉ"} | -|
|๋๊ธ ์ญ์ |DELETE|/api/comments/{id}| - || - |


**๋์ฅ๊ณ **

<table>
<tr>
    <th>๊ธฐ๋ฅ</th>
    <th>METHOD</th>
    <th>URL</th>
    <th>Request</th>
    <th>Response</th>
</tr>
<tr>
    <th>๋์ฅ๊ณ  ์ฌ๋ฃ  ๊ฐ์ ธ์ค๊ธฐ</th>
    <th>GET</th>
    <th>/api/recipe</th>
    <th> - </th>
    <th>{ "id" : 15,  "ingredient" : "๋น๊ทผ" }</th>
</tr>
<tr>
    <th>๋์ฅ๊ณ  ์ฌ๋ฃ ์ถ๊ฐํ๊ธฐ</th>
    <th>POST</th>
    <th>/api/recipe</th>
    <th> { "ingredient" : "๋น๊ทผ" } </th>
    <th> - </th>
</tr>
<tr>
    <th>๋์ฅ๊ณ  ์ฌ๋ฃ  ์ญ์ ํ๊ธฐ</th>
    <th>DELETE</th>
    <th>/api/recipe</th>
    <th> {"ingredient" : "๋น๊ทผ" } </th>
    <th> - </th>
</tr>
<tr>
    <th>์ฌ๋ฃ ์ ํ ์   ์์ ๋ฉ๋ด  ๋ฐ์ดํฐ ๋ฆฌ์คํธ๋ก ์ถ์ถ</th>
    <th>GET</th>
    <th>/api/recipe/{ingredient}</th>
    <th> - </th>
    <th> ["RCP_NM" : "์ค๋ ์ง ๋น๊ทผํ์น"  ,
"ATT_FILE_NO_MK" :   "์ด๋ฏธ์ง URL" ] </th>
</tr>

<tr>
    <th>๋ฉ๋ด ์ ํ ์  ๋ ์ํผ ์ถ์ถ</th>
    <th> GET </th>
    <th>/api/recipe/menu/{query}</th>  
    <th> - </th>
    <th> ["RCP_NM' : '์ค๋ ์ง ๋น๊ทผํ์น",
"ATT_FILE_NO_MK" : "๋ ์ํผ url"
"RCP_PARTS_DTLS" : "์ค๋ ์ง 100g(1/2๊ฐ), ๋ฌผ 50ml(1/4์ปต)"
"'MANUAL01" : "1. ๋ ์ํผ์์1.",
"MANUAL01" : "2. ๋ ์ํผ์์2 ",
"MANUAL01" : "3. ๋ ์ํผ์์3" ]
     </th>
</tr>

</table>


์ค๋ฅ ํด๊ฒฐ ๊ณผ์ 
=================
# ๐คฌCORS ERROR ๐คฌ

 cors์๋ฌ๋?  
ํต์ ์ ํ๋ ค๋ ๋ ์ถ์ฒ๊ฐ ๋ค๋ฅผ ๊ฒฝ์ฐ ์ผ์ด๋๋ ์๋ฌ์ด๋ค   
Cross-Origin Resource Sharing(CORS)์ ์ถ๊ฐ์ ์ธ HTTP header๋ฅผ ์ฌ์ฉํด์ ์ ํ๋ฆฌ์ผ์ด์์ด ๋ค๋ฅธ origin์ ๋ฆฌ์์ค์ ์ ๊ทผํ  ์ ์๋๋ก ํ๋ ๋ฉ์ปค๋์ฆ์ ๋งํ๋ค. ํ์ง๋ง ๋ค๋ฅธ origin์์ ๋ด ๋ฆฌ์์ค์ ํจ๋ถ๋ก ์ ๊ทผํ์ง ๋ชปํ๊ฒ ํ๊ธฐ ์ํด ์ฌ์ฉ๋๋ค.  

๋ธ๋ผ์ฐ์ ๋ `same-origin policy(๋์ผ ์ถ์ฒ ์ ์ฑ)`์ ์ํด `cross-origin`์ ๋ฆฌ์์ค ์์ฒญ์ ์ฐจ๋จํ๋๋ฐ, `cross-origin` ์์ฒญ์ ์ข๋ฅ๋ ์๋์ ๊ฐ๋ค.  
- ๋ค๋ฅธ ๋๋งค์ธ (ex:example.com ์์ test.com์ผ๋ก)
- ๋ค๋ฅธ ํ์ ๋๋ฉ์ธ (ex:example.com์์ store.example.com์ผ๋ก)  
- ๋ค๋ฅธ ํฌํธ(ex: example.com์์ example.com:81 ๋ก)
- ๋ค๋ฅธ ํ๋กํ ์ฝ(ex:https://example.com์์ http://example/com ์ผ๋ก)

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FkA3q6%2FbtqY9ZaZg0s%2FIleHzlgNi2oAxD3MbxRtQ0%2Fimg.png" >  

spring boot๋ฅผ ์ฌ์ฉํ๋ฉด์, RestApi ๋ฐฉ์์ ๊ตฌํํ๋ค๋ณด๋ฉด,   
Postman๊ฐ์ ํ๋ก๊ทธ๋จ์์ ๋ด ๊ธฐ๋ฅ์ ์๋ง ์๋๋๋๋ฐ ์ค์  ๋ฆฌ์กํธ์ ๋ถํ๋ฉด ์๋ฌ๊ฐ ๋ฐ์ํ๋ค.  
React : http://localhost:3000  
Springboot : http://localhost:8081    

`http://localhost:3000`์์ `http://localhost:8081`์ผ๋ก ๋ณด๋ธ ์์ฒญ์ด CORS์ ์ฑ์ ์ํด ์ฐจ๋จ๋์๋ค๋ ๋ด์ฉ์ด๋ค.  
`cross-origin`์ 4๊ฐ์ง ๊ฒฝ์ฐ ์ค ํฌํธ๊ฐ ๋ค๋ฅผ ๊ฒฝ์ฐ์ ํด๋น ๋๋ค.   
๋ Origin๊ฐ์ ํ๋กํ ์ฝ ํฌํธ ํธ์คํธ๊ฐ ๊ฐ์์ผ Same Origin Policy ์ ์ฑ์ ๋ง์กฑ ์ํค๋๋ฐ,  
์ค์ ๋ก Origin์ด ๋ค๋ฅธ ๊ฒฝ์ฐ๊ฐ ํ๋ค ํ๊ธฐ ๋๋ฌธ์, ์๋ฒ์ธก์์ CORS๋ฅผ ์ด์ฉํ์ฌ์ผ ํ๋ค   




### ํด๊ฒฐ ๋ฐฉ๋ฒ : ๋ชจ๋  Request์ ์ ์ฉํ๋ @Configurationํด๋์ค ์์ฑ

์๋ฒ ๋จ์์ ํน์  origin ํน์ ๋ชจ๋  origin์ ํ์ฉํ๋๋ก ์ค์ ํด์ฃผ๊ธฐ๋ง ํ๋ฉด ๋๋ค.   

```java

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    //ํ์ฌ๋ ์ค์  ๋ชจ๋  path, origin, method๋ฅผ ํ์ฉํ๋ค๋ ๊ฒ์
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //CORS๋ฅผ ์ ์ฉํ  URLํจํด์ ์ ์
                .allowedOrigins("*") //์์ฒญ์ ํ์ฉํ  ์ถ์ฒ๋ฅผ ๋ช์, ํ์ฌ๋ ์ ์ฒด ํ์ฉ , ๊ฐ๋ฅํ๋ค๋ฉด url๋ชฉ๋ก์ ์์ฑํ๋ค. ํธ๋ฆฌ๊ธฐ ์ฝ์์ธ ๊ตฌ์กฐ
                .allowedMethods( //์ด๋ค Method๋ฅผ ํ์ฉํ  ๊ฒ์ธ์ง..
                        HttpMethod.GET.name(),
                        HttpMethod.HEAD.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name());
    }

}

```
WebMvcConfigurer์ addCorsMappings ์ฌ์ ์ ํด์ฃผ๋ฉด ๋๋ค.  
์ฒ์์๋ `.allowedOrigins("*")`  ์ด๋ถ๋ถ์ `.allowedOrigins("http://localhost.3000")`์ ํด๋๊ณ  ๊ฐ๋ฐ์ ํ๋ค๊ฐ..   
ํ๋ก ํธ ๋จ์์ ๋ฐฐํฌ๋ฅผ ํ๋ ๋ CORS์๋ฌ๊ฐ ๋ ์ .. ๋นก์ณ์ ์ ์ฒดํ์ฉ์ผ๋ก ๋ฐ๊ฟจ๋ค 

ํ์ฌ ์ค์ ์ ๋ชจ๋  path, origin, ๊ทธ๋ฆฌ๊ณ  ์์ method๋ชฉ๋ก์ ํ์ฉํ๋ค๋ ๊ฑด๋ฐ, ์ํฉ์ ๋ง๊ฒ ์์ ํ๋ฉด ๋๋ค.  
๊ผญ @Configuration์ ์ ์ด ์ค์ผ ์ ์ฉ์ด ๋๋ค!

 


