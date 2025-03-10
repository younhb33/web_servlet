<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    ArrayList<String> data = (ArrayList)request.getAttribute("data");
    String mtel = data.get(1);
    if(data.get(1).length() == 11){ //휴대폰 번호가 11자리
    	mtel = data.get(1).substring(0,3)+"-"+ "****" +"-"+  data.get(1).substring(7,11);
    }else if(data.get(1).length() == 10){ //휴대폰 번호가 10자리
    	mtel = data.get(1).substring(0,3)+"-"+ "***" +"-"+  data.get(1).substring(6,10);
    }
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 예매 확인</title>
</head>
<body>
<p><b>영화 예매확인</b></p>

고객명 : <%=data.get(0)%><br>
연락처 : <%=mtel%><br>
영화선택 : <%=data.get(2)%><br>
예매일자 : <%=data.get(3)%><br>
<button type="button" onclick="smb()">확인</button>
</body>
<script>

function smb() {
	
	if(confirm("예매가 완료 되었습니다! 예매 페이지로 돌아가시겠습니까?")){
		location.href="./movie.html";
	}else{
		alert("해당 페이지 이동을 취소하셨습니다 .");
	}
	
	
	
}



</script>
</html>