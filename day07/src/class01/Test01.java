package class01;

class Point {
	// 1.멤버변수 2.메서드 3.생성자
	int x;
	int y;
	
	Point() { // : 멤버변수 초기화
		this(0, 0);
	}
	
	Point(int x) {
		this(x, x);
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void move() { // 메서드는 this.move()로 재사용 해도 되지만 일반적으로 안 하는것이 좋다
		this.x++;
		this.y++;
	}
	
	void move(int x) {
		this.x += x;
		this.y += x;
	}
	
	void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	void printInfo() {
		System.out.println("현재위치는 (" + this.x + ", " + this.y + ") 입니다.");
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Point p1 = new Point();
		Point p2 = new Point(10);
		Point p3 = new Point(1, 2);
		
		p1.move();
		p1.printInfo();
		
		p2.move(-5);
		p2.printInfo();

		p3.move(3, -4);
		p3.printInfo();
	}

}
