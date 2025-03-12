package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mallpage/join.do")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//footers 클래스 객체 생성 (하단 푸터 데이터 로드)
		footers ft = new footers();
		//푸터 데이터를 cpdata라는 이름으로 request 객체에 저장
		request.setAttribute("cpdata", ft.cdata);
		//join.jsp 페이지로 데이터를 전달하고 포워딩 (화면 출력)
		RequestDispatcher rd = request.getRequestDispatcher("./join.jsp");
		rd.forward(request, response);
	}

}
//footers` 클래스 (하단 푸터 데이터 처리)
class footers extends ab_footer {
	public footers() {
		this.fts(); // fts() 메서드 호출 (부모 클래스에서 푸터 데이터 로드)
	}
	@Override
	public void fts() {
		//부모 클래스 fts() 메서드를 실행하여 copyright 정보를 가져옴
		super.fts();
	}
}