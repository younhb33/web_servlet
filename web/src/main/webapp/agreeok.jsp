<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
   <%
    String check = request.getAttribute("check").toString();
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 정보 입력 [간편가입]</title>
</head>
<body>

<form id="join_form" method="post" action="http://172.30.1.44:8080/web/agreeok_2.do">
아이디 <input type="text" name="mid"><br>
고객명 <input type="text" name="mname"><br>
비밀번호 <input type="password" name="mpass"><br>
이메일 <input type="text" name="memail"><br>
휴대폰번호 <input type="tel" name="mtel"><br>
이미지 <input type="file" name="mfile"><br>
<button type="button" onclick="join_btn()">회원가입</button>
</form>

</body>
<script>
function join_btn(){
	join_form.submit();
}
</script>

</html>
<!--
주은
http://172.30.1.34:8080/web/agreeok.html
나영
http://172.30.1.92:8080/web/agreeok.jsp
하빈  
http://172.30.1.44:8080/web/agreeok_2.jsp
 -->