package email;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.m_dbinfo;


public class mailok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection con = null;
	PreparedStatement ps = null;
	
	String sql = "";  //Query문법
	m_dbinfo db = new m_dbinfo(); //Database정보
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		
		try {
			this.con = db.getConnection();
			String to_name = request.getParameter("to_name");
			String to_mail = request.getParameter("to_mail");
			String subject = request.getParameter("subject");
			String context = request.getParameter("context");
			
			
			String sql = "";
			
			sql = "insert into email values(?,?,?,?,now())";
			this.ps = this.con.prepareStatement(sql);
			this.ps.setString(1, to_name);
			this.ps.setString(2, to_mail);
			this.ps.setString(3, subject);
			this.ps.setString(4, context);
			int result = this.ps.executeUpdate();
			
			if(result > 0) {	//정상적으로 DB에 insert되었을 경우 
				request.setAttribute("to_name", to_name);
				request.setAttribute("to_mail", to_mail);
				request.setAttribute("subject", subject);
				request.setAttribute("context", context);

				request.getRequestDispatcher("mailok.jsp").forward(request, response);

				
			}
			
			String msg = "";
			if(msg.equals("ok")) {
				this.pw.write("<script>"
						+ "alert('메일이 올바르게 전송되었습니다.');"
						+ "location.href='./mailok.jsp';"
						+ "</script>");
			}else {
				this.pw.write("<script>"
						+ "alert('DB 오류 발생!!');"
						+ "history.go(-1);"
						+ "</script>");
			}
			
		} catch (Exception e) {
			this.pw.write("<script>"
					+ "alert('데이터베이스 문제로 인해 전송되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
			
		}finally {
			try {
				this.ps.close();
				this.con.close();
				pw.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}
}
