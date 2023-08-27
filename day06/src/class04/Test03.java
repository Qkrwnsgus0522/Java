package class04;

class Circle {
	String name;
	int radius;
	
	void printInfo() {
		System.out.println(this.name + "은 넓이가 " + this.radius * this.radius * 3.14 + "입니다.");
	}
}

public class Test03 {

	public static void main(String[] args) {
		
		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
		
		circle1.name = "원1";
		circle1.radius = 5;
		circle2.name = "원2";
		circle2.radius = 7;
		
		circle1.printInfo();
		circle2.printInfo();
	}

}
