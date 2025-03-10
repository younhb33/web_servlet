package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pollok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//method="get
	//PrintWriter => Controller에서 종료(결과값에 대해서 처리)
	//RequestDispatcher => Controller => View(jsp) 결과를 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("utf-8");
		//response.setContentType("text/html");
		response.setContentType("text/html;charset=utf-8");
		
		// 동일한 name => radio : 여러개 오브젝트 중에 한가지만 선택
		//getParameter : get,post (name전달됨 값 동일함)
		//request.getParameter : 무조건 Front-end에서 값이 전달되어야 함
		String subject = request.getParameter("subject");//intern()때리면 try밖에 두면 그 밑을 읽지 않음
		String etc[] = request.getParameterValues("etc");//여러개 값을 배열로 받을시 getParameterValues 사용
		//ArrayList<String> etc = new ArrayList<String>(Arrays.asList(request.getParameterValues("etc")));
		PrintWriter pw = response.getWriter();
		
		try {		
			request.setAttribute("etc",etc);
			request.setAttribute("subject", subject); //view에 출력 메소드
			request.setAttribute("abc", "");
			RequestDispatcher rd = request.getRequestDispatcher("./pollok.jsp");
			rd.forward(request, response);			
		} catch (Exception e) {
			pw.write(
					"<script>" 
					+ "alert('올바른 접근이 아닙니다.');"
					+ "</script>");
		}finally {
			pw.close();
		}
	}

}
