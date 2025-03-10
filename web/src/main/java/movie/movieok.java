package movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class movieok extends HttpServlet {
	private static final long serialVersionUID = 1L;
     PrintWriter pw = null;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String mname = request.getParameter("mname");
		String mtel = request.getParameter("mtel");
		String movie = request.getParameter("movie");
		String mdate = request.getParameter("mdate");
		
		ArrayList<String> data = new ArrayList<String>();
		data.add(mname);
		data.add(mtel);
		data.add(movie);
		data.add(mdate);
		
		
		this.pw = response.getWriter();
		
		try {
			request.setAttribute("data", data);
			
			RequestDispatcher rd = request.getRequestDispatcher("./movieok.jsp");
            rd.forward(request, response);
			
			
		} catch (Exception e) {
			pw.write(
					"<script>" 
					+ "alert('올바른 접근이 아닙니다.');"
					+ "history.go(-1);" 
					+ "</script>");
		}finally {
			
		}
		
	}

}
