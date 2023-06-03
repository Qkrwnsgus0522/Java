package class03;

class Shape {
	String name;
	double area;
	
	Shape(String name) {
		this(name, 0.0);
	}
	
	Shape(String name, double area) {
		this.name = name;
		this.area = area;
	}
	
	void printArea() {
		System.out.println(this.name + "의 넓이는 " + this.area + "입니다.");
	}
}

class Circle extends Shape {
	int r;
	final static double PI = 3.14;

	Circle(int r) {
		super("원");
		this.r = r;
		this.area = this.r * this.r * Circle.PI;
	}
	
//	Circle(int r) {
//		this("원", r);
//	}
	
	Circle(String name, int r) {
		super(name);
		this.r = r;
		this.area = this.r * this.r * Circle.PI;
	}
}

class Rect extends Shape {
	int x;
	int y;
	
	Rect(String name, int x, int y) {
		super(name);
		this.x = x;
		this.y = y;
		this.area = this.x * this.y;
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Circle circle1 = new Circle(3);
		Circle circle2 = new Circle("원원", 5);
		Rect rect = new Rect("사각형", 4, 5);
		
		circle1.printArea();
		circle2.printArea();
		rect.printArea();
	}

}
