package class01;

// "포켓몬" 객체는 없는것아닌가요?
// "피카츄, 파이리" 객체만 있으면되는거아닌가요?

// [ 추상 클래스 ]
// "객체화 하는것이 목표가 아니라,
//	설계를 하는것이 목표였던 클래스들"
// "클래스들의 기준이 되는것이 목표"
abstract class Shape {
	String name;
	double area;
	abstract void draw(); // 추상메서드
}

class Rect extends Shape {
	// 오버라이딩을 강제
	@Override
	void draw() {
		System.out.println("네모 그리기");
	}
}

class Circle extends Shape {
	@Override
	void draw() {
		System.out.println("원 그리기");
	}
}

class Tri extends Shape {
	@Override
	void draw() {
		System.out.println("세모 그리기");
	}
}

public class Test02 {

	public static void main(String[] args) {
		
//		Shape s = new Shape(); // 추상클래스이기 때문에 객체화 불가능
		Circle c = new Circle();
		c.draw();
		Rect r = new Rect();
		r.draw();
	}
}
