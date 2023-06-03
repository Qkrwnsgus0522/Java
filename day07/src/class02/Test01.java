package class02;

class A {
	int a; // 멤버변수, 필드, 속성
	// 인스턴스 변수
	// : 각각의 객체들이 고유한 값을 저장, 객체들끼지 값을 공유 xxxxx
	
	static int b; 
	// 객체와 무관하게
	// 클래스 변수, 공유 자원
	// : 주인이 클래스라서 객체들끼리 값을 공유 O
	
	void printInfo() {
		System.out.println("a = " + this.a);
		System.out.println("b = " + b);
	}
}

public class Test01 {
	public static void main(String[] args) {
		
		A a1 = new A();
		a1.a = 10;
		a1.b = 10;
		
		A a2 = new A();
		a2.a = 10;
		a2.b = 10;
		a2.a++;
		a2.b++;
		
		a1.printInfo();
		a2.printInfo();
	}

}
