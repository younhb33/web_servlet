package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//cos 사용없이 자체 라이브러리를 이용하여 설정
@MultipartConfig( //첨부파일 환경설정
		fileSizeThreshold = 1024*1024*2,	//한개의 파일 전송 크기 : 2MB
		maxFileSize = 1024*1024*5, //파일 한개의 최대 크기 용량 : 5MB
		maxRequestSize = 1024*1024*100	//여러개의 첨부파일 전체의 용량 : 100MB
)
public class fileupload extends HttpServlet {
	PrintWriter pw = null;
	private static final long serialVersionUID = 1L;
           
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //한글 파일 날라올 수 있을 경우
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			//Front-end에서 전송된 name값에 I/O처리 방식
			//Part(클라이언트) <=> Multipart(서버)
			Part mfile = request.getPart("mfile");
			String filename = mfile.getSubmittedFileName();
			long filesize = mfile.getSize();
			System.out.println(filesize);
			if(filesize > 2097152) {
				pw.write("<script>" 
						+ "alert('파일 첨부 용량은 최대 2MB까지 입니다..');"
						+ "history.go(-1);"	
						+ "</script>");
			}else {
				/*
				 WEB I/O는 웹 전용 이미지 디렉토리를 별도로
				 구성해야만 정상적으로 웹에서 이미지를 확인 할 수 있습니다.
				 getServletContext(웹 경로) + getRealPath(저장디렉토리)
				 
				 APP I/O => File => InputStream => OutputStream
				 */
				//WEB Server에서 적용된 디렉토리에 저장 되도록 합니다. (src경로 X)
				String url = request.getServletContext().getRealPath("/upload/");
				//String url = request.getServletContext().getRealPath("");//서버경로
				mfile.write(url + filename);
				System.out.println(url); //파일 업로드될 경로
				this.pw.write("<script>"
						+ "alert('정상적으로 파일 업로드 되었습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			
		} catch (Exception e) {
			this.pw.write("<script>"
					+ "alert('올바른 접근방식이 아닙니다..');"
					+ "history.go(-1);"
					+ "</script>");
		}finally {
			this.pw.close();
		}
	}

}
