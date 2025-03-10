package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deliveryok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PrintWriter pw = null;
	
	
	//HttpServletRequest request;
	//HttpServletResponse response;
	
	//즉시실행 메소드(Servlet) : 일반 class에서 사용하는 형태와는 구조 다릅니다. 
	/*
	public deliveryok() { //즉시실행 괄호에 뭐 때리면 안됨
		try {
			this.request.setCharacterEncoding("utf-8");
			this.response.setContentType("text/html;charset=utf-8");
			this.pw = response.getWriter();
		} catch (Exception e) {
			
		}
		
	}
	*/
	//일반 메소드
    public void deliveryok(HttpServletRequest request, HttpServletResponse response) {	//action에서 해당 class 실행하면 즉ㄱ시 메소드 발동
        try {
        	request.setCharacterEncoding("utf-8");
        	response.setContentType("text/html;charset=utf-8");
        	this.pw = response.getWriter();
		} catch (Exception e) {
			System.out.println("해당 URL 경로가 올바르지 않습니다.");
		}
    }
    //매개변수명을 변경하여 request response를 다른 이름으로 변경 가능함
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.deliveryok(req, res);
		
		String mname = req.getParameter("mname");
		String mtel = req.getParameter("mtel");
		String memail = req.getParameter("memail");
		String maddress = req.getParameter("maddress");
		//클래스 배열을 생성하는 이유는 setAttribute가 너무 많이 생성되어 jsp로 전달시 getAttribute가 많아짐
		ArrayList<String> data = new ArrayList<String>();
		data.add(mname);
		data.add(mtel);
		data.add(memail); //DTO 사용할 수 있음
		data.add(maddress);
		
		//클래스 배열을 jsp로 전달
		req.setAttribute("data", data);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("./deliveryok.jsp");
		rd.forward(req, res);
		
		
		
		
	}
}
