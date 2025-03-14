package mallpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.m_dbinfo;

//select: 상품 리스트 Database연결 Model
public class m_product {
	//DTO(setter,getter) 불러오기
	dto_product pd = new dto_product(); //void메소드 일 경우 Contoller에서 가져가는 객체
	ArrayList<ArrayList<String>> all = null;
	ArrayList<String> al = null;
	
	//DB정보 및 연결
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null; //select는 무조건 ResultSet필요
	String sql = null; //DB쿼리문
	
	//디비접속 정보 model
	m_dbinfo db = new m_dbinfo();
	
	//상품하나의 정보만 가져오는 모델
	public void oneproduct(dto_product p) { //Controller에서 보내준 DTO값을 받음
		//System.out.println(p.getMidx());
		try {
			this.con = this.db.getConnection();
			this.sql = "select * from mall_product where midx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, p.getMidx());
			this.rs = this.ps.executeQuery();
			if(this.rs.next() == false) {
				this.pd.setMidx(0);
			}
			else { //필드에 있는 DTO 모델에 setter로 DB값을 이관함
				//System.out.println(this.rs.getString("pnm"));
				this.pd.setMidx(this.rs.getInt("midx"));
				this.pd.setPcode(this.rs.getString("pcode"));
				this.pd.setPnm(this.rs.getString("pnm"));
				this.pd.setPmoney(this.rs.getString("pmoney"));
				this.pd.setPsales(this.rs.getString("psales"));
				this.pd.setPsmoney(this.rs.getString("psmoney"));
				this.pd.setPimg(this.rs.getString("pimg"));
				this.pd.setPdate(this.rs.getString("pdate"));
			}
			
		} catch (Exception e) {
			this.pd.setMidx(0);
		}finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			} catch (Exception e) {
				
			}
		}
		
		
	}
	
	
	//전체 리스트를 가져오는 모델
	public ArrayList<ArrayList<String>> product_all() {
		try {
			this.con = this.db.getConnection();
			this.sql = "select * from mall_product order by midx desc"; 
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			
			this.all = new ArrayList<ArrayList<String>>();
			while(this.rs.next()) {
				this.al = new ArrayList<String>();
				this.al.add(String.valueOf(this.rs.getInt("midx")));
				this.al.add(this.rs.getString("pcode"));
				this.al.add(this.rs.getString("pnm"));
				this.al.add(this.rs.getString("pmoney"));
				this.al.add(this.rs.getString("psales"));
				this.al.add(this.rs.getString("psmoney"));
				this.al.add(this.rs.getString("pimg"));
				this.al.add(this.rs.getString("pdate"));
				this.all.add(this.al);
			}
			
		} catch (Exception e) {
			this.all = null;
		}finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			} catch (Exception e) {
				
			}
		}
		
		return this.all;
	}
	
	
}
