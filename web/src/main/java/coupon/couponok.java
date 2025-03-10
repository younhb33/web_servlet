package coupon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class couponok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String mid = request.getParameter("mid");
		String mcp = request.getParameter("mcp");
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("A1316B1004");
		data.add("C4024A0096");
		data.add("B1987C3136");
		this.pw = response.getWriter();
		try {
			if(data.contains(mcp)) {
				//if(mcp.equals(data.get(0))||mcp.equals(data.get(1))||mcp.equals(data.get(2))) {
					request.setAttribute("mid", mid);
					request.setAttribute("mcp", mcp);
					
					RequestDispatcher rd = request.getRequestDispatcher("./couponok.jsp");
					rd.forward(request, response);
					
				}else {
					this.pw.write("<script>" 
							+ "alert('해당 쿠폰번호를 확인하세요');" 
							+ "history.go(-1);"
							+ "</script>");
				}
		} catch (Exception e) {
			this.pw.write("<script>" 
					+ "alert('올바른 접근방식이 아닙니다.');" 
					+ "history.go(-1);"
					+ "</script>");
		}finally {
			this.pw.close();
		}
	}
}
