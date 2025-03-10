<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String to_name = (String)request.getAttribute("to_name");
    String to_mail = (String)request.getAttribute("to_mail");
    String subject = (String)request.getAttribute("subject");
    String context = (String)request.getAttribute("context");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송된 메일확인 창</title>
</head>
<body>
<p><%=to_name %></p>
담당자 성함:<%=to_name %> <br>
회신받을 메일주소:<%=to_mail %> <br>
제목: <%=subject %><br>
내용:<%=context %> <br>
</body>
</html>