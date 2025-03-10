<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 입력</title>
</head>
<body>
<form id="frm" method="post" action="./part3.do" enctype="multipart/form-data">
<p>회원가입 정보 입력[간편가입]</p>
아이디 : <input type="text" name="mid"><br>
고객명 : <input type="text" name="mname"><br>
비밀번호 : <input type="password" name="mpass" maxlength="12"> * 비밀번호 최소 6~12자리 입니다.<br>
이메일 : <input type="text" name="memail"><br>
휴대폰 번호 : <input type="text" name="mtel" maxlength="11"> * "-"는 입력하지 않습니다.<br>
이미지 : <input type="file" name="mfile">* 이미지 첨부는 최대2MB 이하 입니다.<br>
<button type="button" onclick="gopage()">가입완료</button>
</form>

</body>
<script>
function gopage() {
	if(frm.mid.value==""){
		alert("아이디를 입력하세요");
	}else if(frm.mname.value==""){
		alert("이름을 입력하세요");
	}else if(frm.mpass.value==""){
		alert("패스워드를 입력하세요");
	}else if(frm.mpass.value.length < 6){
		alert("패스워드는 최소 6자 이상 입력하셔야 합니다.");
	}else if(frm.memail.value==""){
		alert("이메일을 입력하세요");	
	}else if(frm.mtel.value==""){
		alert("휴대폰 번호를 입력하세요");
	}else{
		// 모든 조건 충족 시 회원가입 진행 여부 확인
		if(confirm("회원가입을 진행 하시겠습니까?")){ //확인
			//// 확인 버튼 클릭 시 폼 제출
			frm.submit();
		}else{ //취소
			//// 취소 버튼 클릭 시 이전 페이지로 이동
			history.go(-1);
		}
	}
}


</script>
</html>