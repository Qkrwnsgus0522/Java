package class04;

import java.util.Scanner;

// JAVA의 기본단위 == class

// '학생' 코딩해줘.
class Student { // 클래스는 대문자로 시작
	String name;
	int score;
	// 상태 : 멤버변수, 필드, 속성
	
	// 생성자 오버로딩
	Student(String name) {
		this.name = name;
		this.score = 0; // 아직 전학생이라 시험을 안 봤기 때문에
		System.out.println(this.name + "학생 출석부에 입력완료!");
	}

	Student(String name, int score) {
		this.name = name;
		this.score = score;
		System.out.println(this.name + "학생 출석부에 입력완료!");
	}
	
	// static == "객체와 무관하게"
	// 객체와 관련있기 때문에 static X
	void hello() {
		System.out.println("안녕, 난 " + this.name + "야.");
	}
	// 동작(기능) : 메서드, 멤버함수
	// 메서드는 함수에게 주어(주체)가 생긴것!
}

public class Test01 {

	public static void main(String[] args) {
		
		// String, Random, Scanner 모두 클래스
		
		int num = 10;
		double d = 3.14;
		Scanner sc = new Scanner(System.in);
		String str = new String("apple");
		String str2 = "apple";
		
		// 하나의 클래스를 여러번 불러와 객체 생성 가능
		Student student1 = new Student("아무무", 97);
		// 클래스   객체    = new 생성자();
		// 클래스는 자료형, 붕어빵틀의 역할
		// 객체는 변수, 붕어빵의 역할
		// 클래스로부터 객체를 생성할때에는
		//	new 생성자()가 반드시 필요하며
		//	 객체화(인스턴스화)
		// 교재, 유튜브, 인강, 블로그 -> "인스턴스" new해서 나온 객체
		Student student2 = new Student("티모", 13);
		Student student3 = new Student("아리", 56);
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
		
		//      . => 멤버접근 연산자
//		student1.name = "아무무";
//		student1.score = 97;
//		student2.name = "티모";
//		student2.score = 13;
//		student3.name = "아리";
//		student3.score = 56;
		
		student1.hello();
		student2.hello();
		student3.hello();
		
	}

}
