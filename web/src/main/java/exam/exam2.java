package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class exam2 {
	
	public static void main(String[] args) {
		ex2_box ea = new ex2_box();
		ea.aaa();

	}

}
class ex2_box{
	
	ArrayList<Integer> user = null; //사용자 선택한 숫자 담는 클래스 배열 변수 생성
	ArrayList<Integer> pc = null; //PC 선택한 숫자 담는 클래스 배열 변수 생성
	Scanner sc = null;
	public ex2_box() {
		this.sc = new Scanner(System.in);//스캐너 활성화
		this.user = new ArrayList<Integer>(); //클래스 배열 생성
		this.pc = new ArrayList<Integer>();
	}
	public Integer pc_return() {
		Integer npc = (int)Math.ceil(Math.random()*46);
		if(this.pc.contains(npc) == true) { //만약에 pc배열에 담긴 랜덤숫자가 중복일 경우
			pc_return(); //재귀함수 가동
		}
		return npc;
	}

	public void aaa() {
		try {
			while (true) {//무한루프
				if (this.user.size() == 6){ //만약에 사용자 배열사이즈가 6개면 멈추기
					break;
				}
				if(this.pc.size() < 6) {
					Integer npc = (int)Math.ceil(Math.random()*46); //랜덤함수 설정
					if(this.pc.contains(npc) == false) { //만약에 pc배열에 담긴 랜덤숫자가 중복이 없을 경우
						this.pc.add(npc);//pc 클래스 배열에 추가
					}else { //중복 되었을 경우
						//외부 return메소드 재핸들링
						Integer result = this.pc_return();
						this.pc.add(result);
					}
				}
				System.out.println("숫자를 입력하세요 (1~46): "); 
				Integer no = this.sc.nextInt(); //사용자 scanner 입력값
				if (no > 0 && no <= 46) {//만약에 1~46 사이에 선택시
					//같은 숫자 확인/만약에 사용자 배열에 들어간 배열값이 중복이 아닐 경우
					if (this.user.contains(no) == false) {//contains : 문자열에 특정 문자열이 포함되어 있는지 확인하는 함수
						this.user.add(no); //사용자 배열에 추가하기
					}
				} else { // 1~46사이에서 선택하지 않았을 경우
					System.out.println("숫자는 1~46까지만 입력 가능합니다");//경고창 띄우기
				}
			}
			System.out.println(this.user);
			System.out.println(this.pc);
		} catch (Exception e) {
			System.out.println("제발 숫자만 입력하세요!!"); //문자 말고 숫자 입력시 경고창
			new ex2_box().aaa(); //재귀함수 // new+ 클래스 이름. 메소드 이름
		} finally {
			sc.close(); //스캐너 닫기
		}
	}
}