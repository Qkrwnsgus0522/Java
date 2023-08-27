package class06;

class Car {
	String name;
	int current;
	int max;
	
	Car() {
		this.name = "무명";
		this.current = 0;
		this.max = 120;
	}
	
	Car(String name) {
		this.name = name;
		this.current = 0;
		this.max = 120;
	}
	
	Car(String name, int max) {
		this.name = name;
		this.current = 0;
		this.max = max;
	}
	
	void speedUp() {
		if (this.current + 100 > this.max) {
			System.out.println(this.name + " 과속!");
		} else {
			this.current += 100;			
			System.out.println(this.name + " 100 speedUp!");
		}
	}
	
	void speedUp(int speed) {
		if (this.current + speed > this.max) {
			System.out.println(this.name + " 과속!");
		} else {
			this.current += speed;			
			System.out.println(this.name + " " + speed + " speedUp!");
		}
	}
	
	void speedDown() {
		if (this.current == 0) {
			System.out.println(this.name + " 정지...");
		} else {
			this.current -= 10;
			System.out.println(this.name + " 10 speedDown!");			
		}
	}
	
	void speedDown(int speed) {
		if (this.current == 0) {
			System.out.println(this.name + " 정지...");
		} else {
			this.current -= speed;
			System.out.println(this.name + " " + speed + " speedDown!");			
		}
	}
	
	void printInfo() {
		System.out.println(this.name + "님의 차는 [" + this.current + "/" + this.max + "] 입니다.");
	}
}

public class Test03 {

	public static void main(String[] args) {
		
		Car car1 = new Car();
		Car car2 = new Car("홍길동");
		Car car3 = new Car("아무무", 200);
		
		car1.printInfo();
		car2.printInfo();
		car3.printInfo();
		
		car1.speedUp();
		car1.speedUp();
		car2.speedUp();
		
		car2.speedDown();
		car3.speedDown();
		
		car2.speedDown(64);
		car3.speedUp(7);
		
		car1.printInfo();
		car2.printInfo();
		car3.printInfo();
	}

}
