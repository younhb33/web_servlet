package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 페이지 번호를 클릭시 해당 값을 받는 역할 
				String pageno = request.getParameter("pageno");
				
				//페이지번호 인티저로 받으면 null일때 parseInt에서 오류남 
				//String으로 받고 조건 확인하고 parseInt로 넘기기 
				if(pageno ==null || pageno.equals("1")) { //최초 해당 게시판에 접속시 페이지 배열번호 0으로 처리
					pageno = "0";
				}
		
		
		//list 를 출력하기 위한 Database Table을 로드하는 Model
		m_noticelist nl = new m_noticelist(Integer.parseInt(pageno));
		ArrayList<ArrayList<String>> result = nl.db_data();
		//2차 클래스배열로 저장된 Table에 모든 데이터를 세팅함
		request.setAttribute("result", result);
		
		//JSP로 2차 클래스 배열 값을 전달(View)
		RequestDispatcher rd = request.getRequestDispatcher("./notice_list.jsp");
		rd.forward(request, response);
	}

}
