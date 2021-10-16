My Fridge🥢
======================
서비스 주소 : http://eternalclash.shop.s3-website.ap-northeast-2.amazonaws.com/


개발 목표
======================
- [x] : 댓글 CRUD
- [x] : 공공API를 통한 검색 기능
- [x] : 회원가입 & Spring에서의 JWT 방식의 로그인
- [x] : 서로 다른 개발환경 에서의 연동(CORS)


Developers👍
================
총 개발 인원 : 6명  
-Front end🌎 :이수창, 주재일, 이지훈  
-Back end🍃 : 송지은, 이다담, 김선겸  

개요
=====================

*개발 기간 v: 2021-10-11 ~ 2021-10-16  
*스택 : React / Spring  


*주요 기능   

  - 공공데이터를 통한 레시피 검색
  - 재료 추가와 삭체를 통한 냉장고 재료 관리
  - 레시피 하나를 선택하고 거기에 댓글 CRUD 
  - 댓글과 함께 별점 체크
  - 회원가입 & Sprig 에서의 JWT방식의 로그인



사용 기술
====================
`백앤드`
- Java 8
- SpringBoot 
- Gradle
- JPA
- MySQL

`프론트앤드`  

-React

`deploy`  
-AWS EC2
-AWS RDS


⭐️API설계⭐️
=======================

**회원가입**

기능|METHOD|APIURL|REQUEST|RESPONSE|
-----------------|------------|-----------|------------|-------------|
회원가입|GET|/user/signup| - |회원가입 Form Page|
회원가입|POST|/user/signup|{"username" : "아이디","password" : "123","email" : "a@gmail.com}| redirect/user/login |
로그인|POST|/user/login|{"username" : "아이디","password" : "123"} | {"username" : "아이디" , "token":"eyJhbGciOiJIUzI1NiJ9."}|
로그인|GET|/user/login| - || 로그인 Form Page |


**COMMENT**

|기능|METHOD|APIURL|REQUEST|RESPONSE|
|---------|-------|------|-------|--------|
|댓글 조회|GET|/api/comments| - |["username" : "홍길동, "content" : "내용입니다]|
|댓글 등록|POST|/api/comments|{"content" : "내용","recipeTitle" : "단호박 케일밥","star" :4}| -|
|댓글 수정|PUT|/api/comments/{id}| {"cotent" : "수정할내용"} | -|
|댓글 삭제|DELETE|/api/comments/{id}| - || - |


**냉장고**

<table>
<tr>
    <th>기능</th>
    <th>METHOD</th>
    <th>URL</th>
    <th>Request</th>
    <th>Response</th>
</tr>
<tr>
    <th>냉장고 재료  가져오기</th>
    <th>GET</th>
    <th>/api/recipe</th>
    <th> - </th>
    <th>{ "id" : 15,  "ingredient" : "당근" }</th>
</tr>
<tr>
    <th>냉장고 재료 추가하기</th>
    <th>POST</th>
    <th>/api/recipe</th>
    <th> { "ingredient" : "당근" </th>
    <th> - </th>
</tr>
<tr>
    <th>냉장고 재료  삭제하기</th>
    <th>DELETE</th>
    <th>/api/recipe</th>
    <th> {"ingredient" : "당근" } </th>
    <th> - </th>
</tr>
<tr>
    <th>재료 선택 시   음식 메뉴  데이터 리스트로 추출</th>
    <th>GET</th>
    <th>/api/recipe/{ingredient}</th>
    <th> - </th>
    <th> ["RCP_NM" : "오렌지 당근펀치"  ,
"ATT_FILE_NO_MK" :   "이미지 URL" ] </th>
</tr>

<tr>
    <th>메뉴 선택 시  레시피 추출</th>
    <th> GET </th>
    <th>/api/recipe/menu/{query}</th>  
    <th> - </th>
    <th> ["RCP_NM' : '오렌지 당근펀치",
"ATT_FILE_NO_MK" : "레시피 url"
"RCP_PARTS_DTLS" : "오렌지 100g(1/2개), 물 50ml(1/4컵)"
"'MANUAL01" : "1. 레시피순서1.",
"MANUAL01" : "2. 레시피순서2 ",
"MANUAL01" : "3. 레시피순서3" ]
     </th>
</tr>

</table>


오류 오류 해결 과정
=================
# 🤬CORS ERROR 🤬



#### cors에러란?  
통신을 하려는 두 출처가 다를 경우 일어나는 에러이다   
Cross-Origin Resource Sharing(CORS)은 추가적인 HTTP header를 사용해서 애플리케이션이 다른 origin의 리소스에 접근할 수 있도록 하는 메커니즘을 말한다. 하지만 다른 origin에서 내 리소스에 함부로 접근하지 못하게 하기 위해 사용된다.  

브라우저는 `same-origin policy(동일 출처 정책)`에 의해 `cross-origin`의 리소스 요청을 차단하는데, `cross-origin` 요청의 종류는 아래와 같다.  
- 다른 도매인 (ex:example.com 에서 test.com으로)
- 다른 하위 도메인 (ex:example.com에서 store.example.com으로)  
- 다른 포트(ex: example.com에서 example.com:81 로)
- 다른 프로토콜(ex:https://example.com에서 http://example/com 으로)

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FkA3q6%2FbtqY9ZaZg0s%2FIleHzlgNi2oAxD3MbxRtQ0%2Fimg.png" >  

spring boot를 사용하면서, RestApi 방식을 구현하다보면,   
Postman같은 프로그램에서 내 기능은 잘만 작동되는데 실제 리액트에 붙히면 에러가 발생한다.  
React : http://localhost:3000  
Springboot : http://localhost:8081    

`http://localhost:3000`에서 `http://localhost:8081`으로 보낸 요청이 CORS정책에 의해 차단되었다는 내용이다.  
`cross-origin`의 4가지 경우 포트가 다를 경우에 해당 된다.   
두 Origin간에 프로토콜 포트 호스트가 같아야 Same Origin Policy 정책을 만족 시키는데,  
실제로 Origin이 다른 경우가 허다 하기 때문에, 서버측에서 CORS를 이용하여야 한다   




### 해결 방법 : 모든 Request에 적용하는 @Configuration클래스 생성

서버 단에서 특정 origin 혹은 모든 origin을 허용하도록 설정해주기만 하면 된다.   

```java

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    //현재는 설정 모든 path, origin, method를 허용한다는 것임
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //CORS를 적용할 URL패턴을 정의
                .allowedOrigins("*") //요청을 허용할 출처를 명시, 현재는 전체 허용 , 가능하다면 url목록을 작성한다. 털리기 쉽상인 구조
                .allowedMethods( //어떤 Method를 허용할 것인지..
                        HttpMethod.GET.name(),
                        HttpMethod.HEAD.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name());
    }

}

```
WebMvcConfigurer의 addCorsMappings 재정의 해주면 된다.  
처음에는 `.allowedOrigins("*")`  이부분에 `.allowedOrigins("http://localhost.3000")`을 해놓고 개발을 하다가..   
프론트 단에서 배포를 하니 또 CORS에러가 떠서 .. 빡쳐서 전체허용으로 바꿨다 

현재 설정은 모든 path, origin, 그리고 위의 method목록을 허용한다는 건데, 상황에 맞게 수정하면 된다.  
꼭 @Configuration을 적어 줘야 적용이 된다!

 


