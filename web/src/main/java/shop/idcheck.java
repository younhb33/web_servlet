package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con = null;
	//ajax 통신을 받는 메소드(아이디 중복체크)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Back-end가 Front-end에게 결과값을 통보
			PrintWriter pw = response.getWriter();
		
			String msg = ""; // Front-end에게 결과값을 보내는 변수명
			// Ajax로 Front-end가 보낸 데이터를 받는 역할
			try {
				String id = request.getParameter("sid");
				if (id.equals("")) {
					msg = "error";
				}else {
					m_dbinfo db = new m_dbinfo();
					this.con = db.getConnection(); //Database 연결시작
					
					/*
					 * 1. select => ResultSet, executeQuery
					 * 2. insert, update,delete => int, executeUpdate
					 */
					
					//select sid from shop_member where sid = '변수명';
					String sql = "select count(*) as ctn from shop_member where sid='"+id+"'";
					//System.out.println(sql);
					//Statement : Database에 쿼리문을 작성할 수 있도록 사용하는 클래스 메소드
					//createStatement() : create, alter, drop,
					Statement st = this.con.createStatement();
					ResultSet rs = st.executeQuery(sql); //ResultSet = executeQuery결과값을 받는 역할(select)
					
					if(rs.next() == true) { //정상적으로 Query문이 작동했을 경우
						if(rs.getString("ctn").equals("0")) { //해당 데이터가 없을때
							msg = "ok";
						}else { //검색한 데이터가 있을 경우
							msg = "no";
						}
					}
					rs.close();
					st.close();
					/*//반복문 사용했을 경우
					 while(rs.next()) { //rs.next() : 결과값에 대해서 반복문이 실행
					 
						System.out.println(rs.getString("ctn"));						
					}
					*/
				}
				pw.write(msg);
			} catch (NullPointerException ne) { //Front-end가 올바른 값을 전달하지 않을 경우
				msg = "error";
				pw.write(msg); // ok: 사용가능 아이디, no: 사용불능 아이디, error : 데이터 오류
			}catch (Exception e) {
				msg = "CODE ERROR 844";
				pw.write(msg);
			}
			finally {
				pw.close();
			}

		}

}
