package class07;

public class Test01 {

	public static String funcC() {
		// 함수 유형 C
		
		System.out.println("funcC() 동작!");
		
		return "apple"; // 함수 즉시 종료됨!!!!
		
		// System.out.println("funcC()의 마지막 코드");
	}
	
	public static void main(String[] args) {
		
		funcC(); // return값은 해당함수를 호출한 자리로 이동함
		System.out.println("main() 공간 : " + funcC()); 
		//ㄴ>System.out.println("apple"); 
		// 1. println() 해주세요.
		// 2. funcC() 호출해주세요.
		// 2 >> 1
		String msg = funcC();
		// 1. = 대입 연산자
		// 2. funcC() 호출해주세요
		// 2 >> 1
		System.out.println("msg: " + msg);
		
		// 1. 일반적으로 OUTPUT이 존재하는 함수들은
		//	a) 출력하거나,
		//	b) 변수에 저장하거나
		//	해서 활용함
		
		// 2. return값은 해당함수를
	}

}
