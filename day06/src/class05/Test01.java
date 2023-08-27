package class05;

// Point 1. 지역변수 vs 멤버변수
// Point 2. 멤버변수에 대입연산자 사용 XXX
// 			-> 생성자를 정의하여 해결!
class Circle {
	String name;
	int radius;
	double PI;
	double area;
	
	// 생성자
	// 1. input
	// 2. output XXXXX -> 당연히 객체이기때문!
	// 3. 생성자함수명 == 클래스
	// ★★★ 생성자의 존재이유 ★★★
	// : 멤버변수의 값들을 초기화하기위해서 사용함~~~
	Circle(String name, int radius) {
		this.name = name;
		this.radius = radius;
		this.PI = 3.14;
		this.area = radius * radius * PI;
		System.out.println(this.name + "이(가) 생성완료!");
	}
	
	void printInfo() {
		// 갈색: 지역변수
		// 파랑: 멤버변수
		System.out.println(this.name + "은 넓이가 " + this.area + "입니다.");
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		// 생성자를 1개라도 제작하게되면,
		// 더이상 기본생성자는 제공되지않습니다...
		Circle c1 = new Circle("피자", 10);
		Circle c2 = new Circle("도넛", 1);
		
//		c1.name = "피자";
//		c1.radius = 10;
//		c2.name = "도넛";
//		c2.radius = 1;
		
		c1.printInfo();
		c2.printInfo();

	}

}
