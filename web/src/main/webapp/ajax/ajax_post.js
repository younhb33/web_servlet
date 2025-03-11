function ajaxs(){ // 전송 버튼 클릭 시 호출되는 함수
	var mid = document.getElementById("mid"); // id가 'mid'인 입력 요소를 가져옴
	var memail = document.getElementById("memail");
	if(mid.value == ""){// 입력 값이 비어있는지 확인
		alert("아이디를 입력하세요!");
	}else{
		//ajax post통신을 위한 함수호출
		this.ajax_post(mid.value,memail.value);
	}
}
//Ajax POST 전송하는 함수
function ajax_post(mid,memail){
	var http, result; 	//http: Back-end통신, result : Back-end 제공한 데이터
	http = new XMLHttpRequest(); //통신 시작하겠다는 뜻
	http.onreadystatechange = function(){// 요청의 상태가 변경될 때마다 호출되는 콜백 함수 설정
		if(http.readyState==4 && http.status==200){ // 요청이 완료되었고(readyState == 4), 서버 응답이 성공적이면(status == 200)
			console.log(this.response); // 서버로부터 받은 응답을 콘솔에 출력
		}else if(http.status==404){
			console.log("경로 오류 발생!!");
		}else if(http.status==405){
			console.log("통신규격 오류 발생!!");
		}
	}
	/*   //get 통신
	http.open("get","./ajax_postok.do?userid="+mid, true);
	http.send();
	*/
	
	//post 통신
	http.open("post","./ajax_postok.do", true);
	/*
	ajax post 전송시 content-type 적용하여 
	urlencoded를 적용해야만 정상적으로 Back-end에게 값을 전송함
	*/
	http.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	//http.send("userid="+mid); //데이터 값을 한 개 전송
	
	http.send("userid="+mid+"&usermail="+memail); //한 개 이상부터 & 사용
	
}

