package class06;

public class Test01 {
	
	// public : 공개범위
	// static : "객체와 무관하게"
	// void : "아무것도없음" 無
	public static void hello() { // 함수명은 "기능"을 유추할 수 있게 만들어야만 한다!
		// 함수 A유형
		System.out.println("안녕하세요! :D");
	}
	// "함수를 정의(선언)했다."
	
	public static void printStar(int num) {
		// 함수 B유형
		for (int i = 0; i < num; i++) {
			System.out.println("*");			
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("입력");
		hello(); // "함수를 호출(사용)했다."
		System.out.println("메뉴나왔습니다.");
		hello();
		System.out.println("매장? 포장?");
		hello();
		
		//printStar(); // 함수를 사용할 때에는 input, output을 정확히 맞춰서 사용해야한다!
		printStar(5);
		hello();
		printStar(3);
	}

}
