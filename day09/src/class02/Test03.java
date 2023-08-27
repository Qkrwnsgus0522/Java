package class02;

class Shape {
	String name;
	double area;
	
	Shape(String name, double area) {
		this.name = name;
		this.area = area;
	}
	
	void printArea() {
		System.out.println(this.name + "의 넓이는 " + this.area + "입니다.");
	}
}

class Circle extends Shape {
	int radius;
	final static double PI = 3.14;
	Circle(String name, double radius) {
		super(name, (radius * radius) * 1.0 * PI);
	}
}

class Rect extends Shape {
	int x;
	int y;
	Rect(String name, int x, int y) {
		super(name, x * y);
	}
}

public class Test03 {

	public static void main(String[] args) {
		
		Circle circle = new Circle("원", 4);
		Rect rect = new Rect("사각형", 10, 4);
		
		circle.printArea();
		rect.printArea();
		
	}

}
