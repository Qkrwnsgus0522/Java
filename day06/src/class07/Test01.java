package class07;

class Car {
	String name;
	int speed;
	int max;
	
	// 인자가 가장 많은 생성자를 먼저 만들어 놓고 다른 생성자에서 가져다가 씀
	// this() == 생성자 함수
//	Car() {
//		this.name = "무명";
//		this.speed = 0;
//		this.max = 120;
//	}
	Car() {
		this("무명", 120);
		System.out.println("확인 1");
	}
	
//	Car(String name) {
//		this.name = name;
//		this.speed = 0;
//		this.max = 120;
//	}
	Car(String name) {
		this(name, 120);
		System.out.println("확인 2");
	}
	
	Car(String name, int max) {
		this.name = name;
		this.speed = 0;
		this.max = max;
		System.out.println("확인 3");
	}
	
	void printInfo() {
		System.out.println(this.name + "님의 차는 [" + this.speed + " / " + this.max + "] 입니다.");
	}
	
	void speedUp() {
		this.speed += 100;
		if (this.speed > this.max) {
			this.speed = this.max;
			System.out.println("과속!");
		}
	}
	
	void speedDown() {
		this.speed -= 10;
		if (this.speed <= 0) {
			this.speed = 0;
			System.out.println("정지...");
		}
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		Car c2 = new Car("홍길동");
		Car c3 = new Car("아무무", 200);
		
		c1.printInfo();
		c2.printInfo();
		c3.printInfo();

	}

}
