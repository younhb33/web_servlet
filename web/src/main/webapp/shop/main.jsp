<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//out.print 적용했을 때 null로 출력 될 경우(session) => 연산기호 사용
	HttpSession hs = request.getSession();
	String mid = (String)hs.getAttribute("mid");
	String mnm = (String)hs.getAttribute("mnm");
	if(mid == null || mnm == null){ //로그인이 되어 있을 경우 다시 로그인 하지 못하도록 처리
		out.println("<script>"
		+"alert('이미 로그인 하셨습니다.');"
		+ "location.href='./main.jsp';"
		+"</script>");		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 메인 화면</title>
</head>
<body>
<%if(mid == null||mnm == null ){ %>
<input type="button" value="로그인">
<% }else {  //Controller에서 정상적으로 로그인을 하여 session이 적 용되었을 경우%>
[<%=mid %>] <%=mnm %>님 환영합니다. <input type="button" value="로그아웃" onclick="logout()">
<% } %>
</body>
<script>
function logout() {
	location.href="./logout.jsp";
}

</script>
</html>