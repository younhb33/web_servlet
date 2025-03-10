<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String mid = (String)request.getAttribute("mid");
    String mcp = (String)request.getAttribute("mcp");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 등록 완료 페이지</title>
</head>
<body>

<script>
alert("정상적으로 쿠폰이 등록 되었습니다!");//쿠폰 등록 완료 메세지 띄우기
</script>


<p><b>쿠폰 등록 완료 페이지</b></p>
아이디 : <%=mid%><br>
쿠폰번호 : <%=mcp%><br>
광고 수신 동의함

</body>
</html>