package mallpage;

import java.util.ArrayList;
//추상 클래스 (푸터 데이터를 제공하는 역할)
public abstract class ab_footer {
	//copyright정보 Model
	// copyright 클래스 객체 생성 (저작권 정보 처리)
	copyright cr = new copyright();
	// 푸터 데이터를 저장할 리스트
	ArrayList<String> cdata = null;
	public void fts() {
		this.cdata = this.cr.copyright_info(); // copyright_info() 호출하여 데이터 가져오기
		
	}
}