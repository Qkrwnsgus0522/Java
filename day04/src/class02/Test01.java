package class02;

public class Test01 {

	public static void main(String[] args) {
		
		int a = 10;
		System.out.println("a= " + a);
		a = 100;
		System.out.println("a2= " + a);
	
		//////////////////
		
		for (int i = 0; i < 3; i++) {
			System.out.println("i= " + i);
		}
		// i가 16번 라인에서 소멸되어 출력 불가능 !
		//	: System.out.println("i= " + i);
		
		for (int i = 10; i < 13; i++) {
			System.out.println("i2= " + i);
		}
		
		// [지역변수의 특성]
		// 일반적으로 "변수"는 거의 대부분 '지역변수'
		// 지역변수 : 선언된 지역({} 블록구간)에서만 사용가능하며,
		//			해당 지역을 벗어나게 되면 소멸됨(메모리 해제)
	}

}
