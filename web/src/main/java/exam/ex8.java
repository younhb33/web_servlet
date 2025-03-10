package exam;

import java.util.ArrayList;
import java.util.Arrays;

// 추상 클래스를 상속받아 기능을 구현하는 클래스
public class ex8 extends ex8_box { 

    public static void main(String[] args) {
        new ex8().even(); // 짝수만 출력하는 메서드 호출
        new ex8().odd();  // 홀수만 출력하는 메서드 호출 (아직 미구현)
    }

    @Override
    public void even() {
        // 부모 클래스의 정수 배열을 ArrayList로 변환
        ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(this.data));
        int w = 0; // 배열의 마지막 인덱스부터 시작
        while (w < number.size()) {
            if (number.get(w) % 2 != 0) { // 현재 요소가 홀수인 경우
                number.remove(w); // remove시 배열의 index즉 node번호가 변경됨
                w = 0; //0사용은 배열에 값이 삭제 되면 노드 변화로 처음부터 다시검토 하도록함 
            }else {
            	w++; //해당 조건(홀수)가 아니면 1+ 증가시켜서 배열 검토하는 형태
            }
        }
        
        // 뒤에서부터 순회하며 홀수를 삭제 (앞에서부터 하면 인덱스가 밀려서 오류 발생 가능)
        
        /*
        int w = number.size() - 1; // 배열의 마지막 인덱스부터 시작
        while (w >= 0) {
            if (number.get(w) % 2 != 0) { // 현재 요소가 홀수인 경우
                number.remove(w); // 해당 요소 삭제
                // remove 실행 후에도 w-- 하므로, 안전하게 반복 가능
            }
            w--; // 인덱스를 감소시키면서 반복
        }System.out.println(number);
        */
        
        // 짝수만 남은 리스트 출력
        System.out.println(number);
    }

    @Override
    public void odd() {
        // 홀수만 출력하는 메서드 (아직 미구현)
    }

    public void dataload() {
        // 데이터 로드하는 메서드 (현재 비어 있음)
    }
}

// 추상 클래스 선언 (부모 클래스)
abstract class ex8_box {
    // 초기 데이터 배열 선언 (짝수, 홀수 섞여 있음)
    Integer data[] = {3, 5, 2, 1, 6, 7, 8, 9, 10, 4}; 
    
    // 데이터 출력하는 메서드 (사용되지 않음)
    public void sum(Integer data) {
        System.out.println(this.data);
    }

    // 짝수만 출력하는 메서드 (구현해야 함)
    abstract public void even(); 

    // 홀수만 출력하는 메서드 (구현해야 함)
    abstract public void odd();
}
