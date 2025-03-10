package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig( //첨부파일 환경설정
		fileSizeThreshold = 1024*1024*2,	//한개의 파일 한 개의 최대용량 크기 : 2MB
		maxRequestSize = 1024*1024*100	//여러개의 첨부파일 전송시 총 용량 : 100MB
)

public class part3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //회원가입 완료
	PrintWriter pw = null;
	String url = null; //웹 경로를 저장하는 변수
	String filenm = null; //파일 명을 저장하는 변수
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			
			
            String mid = request.getParameter("mid");      // 아이디
            String mname = request.getParameter("mname");  // 고객명
            String mpass = request.getParameter("mpass");  // 비밀번호
            String memail = request.getParameter("memail");// 이메일
            String mtel = request.getParameter("mtel");    // 전화번호
            Part mfile = request.getPart("mfile");         // 업로드된 파일 정보 가져오기
            
			if(mid.equals("") || mname.equals("") || mpass.equals("") || memail.equals("") || mtel.equals("")) {
				this.pw.write("<script>"
						+ "alert('올바른 데이터 접근이 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}else { // 사용자 정보가 정상적으로 입력되었을 경우 파일 처리 진행
				
				
				this.filenm = mfile.getSubmittedFileName(); // 업로드된 파일의 파일명 가져오기
				
				
				if(this.filenm != null && this.filenm != "") { // 파일이 있을 경우
					long size = mfile.getSize(); // 업로드된 파일 크기 가져오기
					if(size > 2097152) { // 파일 크기가 2MB를 초과할 경우
						this.pw.write("<script>"
								+ "alert('첨부파일을 최대 2MB까지 입니다.');"
								+ "history.go(-1);"
								+ "</script>");
					}else { //첨부파일이 용량 2MB이하일 경우 서버에 저장
						//web경로
						this.url = request.getServletContext().getRealPath("/user/");
						mfile.write(this.url + this.filenm); //첨부 파일 이미지
					}
				}
			}
			//JSP에 값을 전달
			request.setAttribute("mid", mid);
			request.setAttribute("mname", mname);
			request.setAttribute("memail", memail);
			request.setAttribute("mtel", mtel);
			request.setAttribute("image", this.filenm);
			
			RequestDispatcher rd = request.getRequestDispatcher("./part3.jsp");
			rd.forward(request, response);
			
			
			
		} catch (Exception e) {
			
		}finally {
			this.pw.close();
		}
	}

}

