package class08;

class Point {
	int x;
	int y;
	
	Point() {
		this(0, 0);
	}
	
	Point(int x) {
		this(x, x);
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void move() {
		move(1, 1);
	}
	
	void move(int x) {
		move(x, x);
	}
	
	void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	void printInfo() {
		System.out.println("현재위치는 (" + this.x + ", " + this.y + ") 입니다.");
	}
}

public class Homework01 {

	public static void main(String[] args) {
		
		Point point1 = new Point();
		Point point2 = new Point(10);
		Point point3 = new Point(2, 3);
		
		point1.printInfo();
		point2.printInfo();
		point3.printInfo();
		
		point1.move(3);
		point2.move();
		point3.move(4, 5);
		
		point1.printInfo();
		point2.printInfo();
		point3.printInfo();

		
		
	}

}
