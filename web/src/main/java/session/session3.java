package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 	session : 일정시간 동안 브라우저에 해당 값을 저장 및 유지시키는 방식(Back-end)
 	cookie : 브라우저 cache메모리에 값을 저장하는 방식 (도메인 및 IP 기준) - Front,Backend
 	storage : 메모리에 저장 (Front, Backend) => local, session
 */

public class session3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		//se.invalidate(); //모든 session의 값을 초기화(삭제)   invalidate: 무효화
		se.removeAttribute("tel"); //특정 session값만 삭제를 할 수 있음
	}

}
