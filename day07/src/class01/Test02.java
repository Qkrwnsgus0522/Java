package class01;

import java.util.Random;

class Student {
	String name;
	int[] score;
	double avg;
	char grade;
	
	Student(String name) { // 생성자 : 멤버변수 초기화
		this(name, 2);
	}
	
	Student(String name, int cnt) {
		this.name = name;
		this.score = new int[cnt];
		
		this.makeScore();
		System.out.println(this.name + "은 시험을 " + this.score.length + "번 봅니다.");
	}
	
	void makeScore() {
		Random rand = new Random();
		int sum = 0;
		for (int i = 0; i < this.score.length; i++) {
			this.score[i] = rand.nextInt(101);
			sum += this.score[i];
		}
		this.avg = sum * 1.0 / this.score.length;
		this.grade = 'C';
		if (this.avg >= 80.0) {
			this.grade = 'A';
		} else if (this.avg >= 60.0) {
			this.grade = 'B';
		}
	}
	
	void printInfo() {
		System.out.println(this.name);
		for (int i = 0; i < this.score.length; i++) {
			System.out.println((i + 1) + "번 시험 " + this.score[i] + "점");
		}
		System.out.println("평균 " + this.avg + "점 [" + this.grade + "]");
	}
	
	void test() {
		this.makeScore();
		System.out.println(this.name + "은 재시험을 봅니다.");
	}
}

public class Test02 {

	public static void main(String[] args) {
		
		Student stu1 = new Student("럭스");
		Student stu2 = new Student("유미", 4);
		
		stu1.printInfo();
		stu2.printInfo();
		
		stu1.test();
		stu1.printInfo();

	}

}
