<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Shop Bag</title>
    <meta charset="utf-8" />
    <link href="./index.css" rel="stylesheet" />
    <link href="./subpage.css" rel="stylesheet" />
    <link href="./menu.css?v=1" rel="stylesheet"/>
  </head>
  <body>
<!-- 상단 로고 & 메뉴 -->
<%@ include file="./top.jsp" %>
  <!-- 상단 로고 & 메뉴 -->  
 <!-- 로그인/회원가입 및 비회원 주문조회 -->
 <main>
 <%@ include file="./login_view.jsp" %>
</main>
<!-- 로그인/회원가입 및 비회원 주문조회 -->
<!-- 카피라이터 및 하단 -->
<footer>
<%@ include file="./footer.jsp" %>
</footer>
<!-- 카피라이터 및 하단 -->
  </body>
</html>