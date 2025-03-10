package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//session1 => session을 생성하는 컨트롤러
public class session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PrintWriter pw = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		//정상적인 로그인 상황
		if(mid.equals("hong") && mpass.equals("a1234")) {
				String username="홍길동";
				String usertel = "01012341004";
				///HttpSession: 브라우저에 cashe 메모리에 데이터를 임시저장
				HttpSession se = request.getSession();
				//session을 생성
				se.setAttribute("id", mid); //아이디
				se.setAttribute("name", username); //이름
				se.setAttribute("tel", usertel);
				
		}else { //아이디 및 패스워드가 틀릴 경우
			this.pw.write("<script>"
					+ "alert('아이디 및 패스워드를 확인하세요');"
					+ "history.go(-1);"
					+ "</script>");
		}
		this.pw.close();
	}

}
