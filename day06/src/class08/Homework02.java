package class08;

import java.util.Random;

class Student {
	String name;
	int[] score;
	double avg;
	char grade;
	
	Student(String name) {
		this(name, 2);
	}
	
	Student(String name, int cnt) {
		this.name = name;
		this.score = new int[cnt];
		this.avg = 0 ;
		this.grade = ' ';
	}
	
	void test() {
		Random rand = new Random();
		
		for(int i = 0; i < this.score.length; i++) {
			score[i] = rand.nextInt(101);
		}
	}
	
	void printInfo() {
		int sum = 0;
		System.out.println(this.name);
		for (int i = 0; i < this.score.length; i++) {
			System.out.println((i + 1) + "번 시험 " + this.score[i]);
			sum += this.score[i];
		}
		this.avg = sum * 1.0 / this.score.length;
		if (this.avg >= 80) {
			this.grade = 'A';
		} else if (this.avg >= 60) {
			this.grade = 'B';
		} else {
			this.grade = 'C';
		}
		System.out.println("평균 " + this.avg + "점 [" + this.grade + "]");
	}
}

public class Homework02 {

	public static void main(String[] args) {
		
		Student student1 = new Student("럭스");
		Student student2 = new Student("유미", 4);
		Student student3 = new Student("유미", 7);
		
		student1.test();
//		student2.test();
//		student3.test();
		
		student1.printInfo();
//		student2.printInfo();
//		student3.printInfo();

		student1.test();
		
		student1.printInfo();

	}

}
