<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
HttpSession se = request.getSession();
String mid = (String)se.getAttribute("mid");
String mname = (String)se.getAttribute("mname");
String memail = (String)se.getAttribute("memail");

%>


<%--
loginok.do 에서 만든 세션을 top.jsp에 넣으면 모든 서브페이지에 적용됨!!!!!!!!!!
--%>


<header>
	<div class="navbar">
		<a href="./index.do" id="logo"> 
		<img src="images/logo.jpg" width="149">
		</a>
		<ul id="menu">
			<%
		if(mid != null){
			
		%>
			<li><a href="mailto:<%=memail %>">(<%=mid %>)<%=mname %>님 환영합니다.</a> <a href="./top_logout.jsp">[로그아웃]</a></li>
			<%
		} else{		
		%>

			<li><a href="./login.do">LOGIN</a></li>
			<li><a href="./join.do">MEMBER SHIP</a></li>
			<%
		}
		%>
			<li><a href="#">CART</a></li>
			<li><a href="#">CUSTOMER CENTER</a></li>
		</ul>
	</div>
</header>
<nav>
	<div class="menu-list">
		<ul>
			<li>대메뉴1</li>
			<li>대메뉴2</li>
			<li>대메뉴3</li>
			<li>대메뉴4</li>
			<li>대메뉴5</li>
			<li>대메뉴6</li>
			<li>대메뉴7</li>
		</ul>
	</div>
</nav>