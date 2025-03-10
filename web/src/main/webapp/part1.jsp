<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 [약관동의]</title>
</head>
<body>
<form id="frm" method="get" action="./part2.do">
<p>회원가입 약관</p>
<input type="checkbox" id="all" onclick="all_check(this.checked)">전체선택<br>
<input type="checkbox" name="agree" value="Y0" onclick="ag_check()">서비스 이용약관 동의(필수)<br>
<input type="checkbox" name="agree" value="Y1" onclick="ag_check()">개인정보 수집 및 이용(필수)<br>
<input type="checkbox" name="agree" value="Y2" onclick="ag_check()">이메일 정보 수신 약관(필수)<br>
<input type="checkbox" name="agree" value="Y3" onclick="ag_check()">광고성 정보 수신(선택)<br>
<input type="button" value="회원가입" onclick="go_page()">
</form>
</body>
<script>
function go_page() { //part2.do 전송
	if(frm.agree[0].checked == true && frm.agree[1].checked == true && frm.agree[2].checked == true ){
		frm.submit();
		}else{
			alert("필수 조건은 무조건 동의 하셔야만 회원가입이 진행 됩니다.");
		}
}

	
var all_check = function(z) {
	var ob = frm.agree; //form태그 안에서 agree라는 name명을 가진 오브젝트 전체
	var ea = ob.length; // 체크박스 개수를 저장
	var w = 0; // 반복문을 위한 변수 초기화
	//do~while 문을 사용하여 모든 체크박스 상태를 전체 선택 체크박스 상태와 동일하게 설정
	do{
		ob[w].checked = z;	// 현재 반복 중인 체크박스를 전체 선택 상태(z)와 동일하게 설정
		w++ // 다음 체크박스로 이동
	}while(w < ea); // 모든 체크박스를 순회할 때까지 반복
}
// 전체 선택 체크박스 클릭 시 실행되는 함수
//하나라도 false일 경우 전체선택을 해제 또는 모두 체크가 되었을 경우 전체 선택이 체크됨
var ag_check = function() {	
	var ob = frm.agree; // form 태그 내에서 name="agree"인 모든 체크박스를 가져옴 (배열 형태)
	var ea = ob.length; // 체크박스 개수를 저장
	var w = 0;
	var count = 0; // 체크된 체크박스 개수를 세기 위한 변수 초기화
	while(w < ea){
		if(ob[w].checked == true){ //현재 체크박스가 체크된 상태인지 확인
			count++; // 체크된 개수 증가
		}
		w++;
	}
	//모든 체크박스가 체크되었을 경우 전체 선택 체크박스를 체크
	if(ea == count){
		document.getElementById("all").checked = true; // 전체 선택 체크박스 체크
	}else{
		document.getElementById("all").checked = false; //하나라도 체크 해제되면 전체 선택 체크 해제
	}
}



</script>
</html>