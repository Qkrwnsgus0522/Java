package class04;

class Shape {
	String name;
	double area;
	
//	Shape() {
//		
//	}
	
	Shape(String name) {
		this.name = name;
		this.area = 0.0;
	}
	
	void print() {
		System.out.println(this.name + "는(은) 넓이가 " + this.area);
	}
	
}

class Rect extends Shape {
	int x;
	int y;
	Rect(int x, int y) {
		super("네모");
		this.x = x;
		this.y = y;
		this.area = this.x * this.y;
	}
	
	void print() { // 오버라이딩
		System.out.print(this.name + "는(은) ");
		System.out.print("가로의 길이가 " + this.x + ", ");
		System.out.println("세로의 길이가 " + this.y + "입니다.");
		System.out.println("넓이가 " + this.area + "입니다.");
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Rect r = new Rect(10, 20);
		r.print();
	}

}
