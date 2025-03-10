package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.m_dbinfo;

//DB에 있는 모든 데이터를 가져오는 역할 (Model)
public class m_noticelist {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql; //SQL Query
	
	m_dbinfo db = new m_dbinfo(); //DB연결 Model
	
	ArrayList<String> data = null; //1차 배열 각 컬럼별 값을 저장
	ArrayList<ArrayList<String>> alldata = null;  //Database에 전체 데이터를 저장
	public m_noticelist() {
		
	}
	
	public ArrayList<ArrayList<String>> db_data() {
		try {
			this.con = db.getConnection();
			//필요한 컬럼만 지정하여 select문법으로 데이터를 가져오는 코드
			this.sql = "select nidx,subject,writer,nview,ndate from notice order by nidx desc";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery(); //select
			
			//반복문으로 Table에 있는 컬럼을 1차 배열로 이관 후 2차 배열에 담는 코드
			this.alldata = new ArrayList<ArrayList<String>>();
			while(this.rs.next()) {
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("nidx"));
				this.data.add(this.rs.getString("subject"));
				this.data.add(this.rs.getString("writer"));
				this.data.add(this.rs.getString("nview"));
				this.data.add(this.rs.getString("ndate"));
				this.alldata.add(this.data);
				
			}
			
			
		}catch(Exception e) {
			this.alldata = null;
		}finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (Exception e2) {
				this.alldata = null;
			}
			
		}
		//Model에서 Controller로 데이터를 회신함
		return this.alldata;
	}
	
}
