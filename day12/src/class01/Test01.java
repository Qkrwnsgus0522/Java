package class01;

import java.util.ArrayList;

public class Test01 {

	public static void main(String[] args) {
		
//		int[] data = new int[3];
//		data[0] = 10;
//		data[1] = 20;
//		data[2] = 30;
//		System.out.println(data);
//		
//		// 배열 삽입 불가
//		data[3] = 40;
//		System.out.println(data[3]);
		
		// 향상된 배열 == 배열리스트
		// 1. 데이터를 마음대로 저장가능
		// 2. toString() 오버라이딩
		// 3. add(), remove(), clear(), size(), get(), ...과 같은 다양한기능의 메서드를 기본제공
		// 4. 서로 다른 자료형(타입)들도 저장가능
		//		=> 그러나, 반드시, 서로 같은 자료형만 취급!!!!
		//		=> 그래서 "강제성"을 부여하여 사용합니다!~~
		// ★ 제네릭 <> : 일반화, 배열리스트에 저장될 타입 강제
		ArrayList<String> data1 = new ArrayList<String>();
		
		// Wrapper 클래스
		Integer i = new Integer(10);
		int ii = 10;
		
		ArrayList data = new ArrayList();
		data.add(10);
		data.add(0, 20); // 해당 배열 인덱스 번호에 값 삽입
		data.add(0, 30);
		data.add(20);
		data.add(30);
		data.add(40);
		data.add(50);
		data.add(60);
		data.add(70);
		data.add(80);
		data.add(90);
		data.add("사과");
		data.clear(); // 배열 초기화
		data.add(100);
		System.out.println(data.isEmpty()); // 배열이 비어있는지 확인 true / false
		System.out.println(data);
		System.out.println(data.get(0)); // 해당 배열 인덱스 번호 값 출력
		data.remove(0); // 해당 배열 인덱스 번호 값 제거
		System.out.println(data.size()); // 해당 배열 크기 출력
	}

}
