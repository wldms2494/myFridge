My Fridge🥢
=====================
서비스 주소 : 


개발 목표
======================
- [x] :  댓글 CRUD
- [x] : 공공API를 통한 검색 기능
- [x] : JWT 방식의 로그인


Developers👍
================
총 개발 인원 : 6명  
-Front end🌎 :이수창, 주재일, 이지훈  
-Back end🍃 : 송지은, 이다담, 김선겸  

개요
=====================

*개발 기간 : 2021-10-11 ~ 2021-10-16  
*스택 : React / Spring  


*주요 기능   
  - 원하는 재료를 냉장고에 추가하고 재료에 맞는 레시피 검색
  - 레시피 하나를 선택하고 거기에 댓글에 대한 CRUD 가능
  - 댓글과 함께 별점 체크
  - JWT를 이용한 로그인





개발 환경 
====================


⭐️API설계⭐️
=======================

**회원가입**

|기능|METHOD|APIURL|REQUEST|RESPONSE|
|:-------:|:-------:|:------:|:-------------:|:-------------:|
|회원가입|GET|/user/signup| - |회원가입 Form Page|
|회원가입|POST|/user/signup|{"username" : "아이디","password" : "123","email" : "a@gmail.com}| redirect/user/login |
|로그인|POST|/user/login|{"username" : "아이디","password" : "123"} | {"username" : "아이디" , "token":"eyJhbGciOiJIUzI1NiJ9.  eyJzdWIiOiI1NTU1IiwiaWF0IjoxNjM0MDg5NzA3LCJleHAiOjE2MzQxNzYxMDd9.  zUYfzlN7jAj25Ka5Q_qWyzkGZuVIeeKq0jvND3JObe4"}|
|로그인|GET|/user/login| - || 로그인 Form Page |


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
    <th>냉장고 재료 가져오기</th>
    <th>GET</th>
    <th>/api/recipe</th>
    <th> - </th>
    <th>{ "id" : 15, "ingredient" : "당근" }</th>
</tr>
<tr>
    <th>냉장고 재료 추가하기</th>
    <th>POST</th>
    <th>/api/recipe</th>
    <th> { "ingredient" : "당근" </th>
    <th> - </th>
</tr>
<tr>
    <th>냉장고 재료 삭제하기</th>
    <th>DELETE</th>
    <th>/api/recipe</th>
    <th> {"ingredient" : "당근" } </th>
    <th> - </th>
</tr>
<tr>
    <th>재료 선택 시  음식 메뉴 데이터 리스트로 추출</th>
    <th>GET</th>
    <th>/api/recipe/{ingredient}</th>
    <th> - </th>
    <th> "RCP_NM" : "오렌지 당근펀치"  ,
"ATT_FILE_NO_MK" :   "이미지 URL"  </th>
</tr>
<tr>
    <th>메뉴 선택 시 레시피 추출</th>
    <th> GET </th>
    <th>/api/recipe/meny/{query}</th>
    <th> - </th>
    <th> "RCP_NM' : '오렌지 당근펀치",
"ATT_FILE_NO_MK" : "레시피 url"
"RCP_PARTS_DTLS" : "오렌지 100g(1/2개), 물 50ml(1/4컵)"

"'MANUAL01" : "1. 레시피순서1.",
"MANUAL01" : "2. 레시피순서2 ",
"MANUAL01" : "3. 레시피순서3",
     </th>
</tr>

</table>


