package class01;

class A { // 기존에 있었던 클래스
	// 부모 클래스, 상위 클래스
	int a;
	void funcA() {
		System.out.println("a= " + this.a);
	}
}
// 부모클래스에서는 자식클래스의 내용에 접근 xxx
// 자식클래스에서는 부모클래스의 멤버변수, 메서드에 접근 O
class B extends A { // 기존에 존재했던 클래스를 보고 추가로 구현한 클래스
	// 자식 클래스, 하위 클래스
	int b;
	void funcB() {
		System.out.println("b= " + this.b);
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		A aaa = new A(); // 객체화(인스턴스화)
		aaa.a = 10; // aaa -> a, funcA()
		
		B bbb = new B(); // bbb -> a, b, funcA(), funcB()
		bbb.a = 22;
		bbb.b = 20; // 
		
		aaa.funcA();
		
		System.out.println();
		
		bbb.funcA();
		bbb.funcB();

	}

}
