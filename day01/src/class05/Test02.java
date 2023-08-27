package class05;
class A {
	
}
public class Test02 {

	public static void main(String[] args) {
		// 변수 만들어보기
		// 1.공간 2.주소 3.이름
		int data; // 변수 생성완료된 모습!
		// 여기까지가 변수의 필수 3요소
		
		// 해쉬값 주소
		A a = new A();
		System.out.println(a);
		
		// 이제, 변수가 생겼으니까
		// "데이터(값, value)"를 저장해볼까요?
		data = -321; // --->> [초기화]
		// = : 대입 연산자
		
		System.out.println("data라는 이름의 변수에 저장된 값음");
		System.out.println(data);
		// The local variable data may not have been initialized
		// 저장된 값이 없기 때문에 실행할 수 없음
		// => "초기화"라는 작업을 해야함!
		// : 변수에 최초로 값을 저장하는 작업
		System.out.println("입니다.");
		
		// [연습문제]
		// 문자열 "안녕하세요"를 저장하고싶어요.
		// 저장된 공간의 이름을 hello라고 해주세요.
		// 이 변수 hello를 활용하여 console창에 "안녕하세요"를 두 번 출력해주세요!
		
		String str;
		str = "안녕하세요";
		System.out.print(str);
		System.out.println(str);
	}

}
