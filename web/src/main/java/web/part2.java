package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class part2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //part1에서 Get으로 전송하므로 doGet만 설정함
	PrintWriter pw = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			this.pw = response.getWriter(); // 응답 데이터를 작성하기 위해 PrintWriter 객체 생성
			//getParameterValues => 배열
			// 클라이언트가 보낸 다중 체크박스 값을 받아 배열로 저장
			String agree[] = request.getParameterValues("agree");
			int ea = agree.length; // 배열 크기(선택된 체크박스 개수) 저장
			int w=0;
			int ckcount = 0; // 필수 약관 동의 개수를 세기 위한 변수
			//반복문을 통해 필수 약관(서비스 이용, 개인정보 수집, 이메일 수신) 확인
			while(w < ea) {
				if(agree[w].equals("Y0") || agree[w].equals("Y1") || agree[w].equals("Y2")) {
					ckcount++; //// 필수 약관이 체크되었을 경우 카운트 증가
				}
				w++;
				//필수 약관이 3개 미만으로 선택되었을 경우
			}if(ckcount < 3) {
				this.pw.write("<script>" 
						+ "alert('올바른 접근방식이 아닙니다.');" 
						+ "location.href='./part1.jsp';" 
						+ "</script>");
			}else { //해당 조건이 맞을 경우 part2.jsp 로드
				RequestDispatcher rd = request.getRequestDispatcher("./part2.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			this.pw.write("<script>" 
					+ "alert('시스템 오류로 인하여 데이터 처리가 되지 않았습니다.');" 
					+ "location.href='./part1.jsp';" 
					+ "</script>");
		}finally {
			this.pw.close();
		}
	}

}
