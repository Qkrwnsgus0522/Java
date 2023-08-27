package project;

import java.util.Scanner;

class Student {
	String name;
	int score;
	
	Student(String name, int score) {
		this.name = name;
		this.score = score;
		System.out.println(name + " 학생 생성완료!");
	}
	
	void updateScore(int score) {
		this.score = score;
	}
	
	void printInfo(int num) {
		System.out.println(num + "번 " + this.name + " " + this.score + "점");
	}
	
	void printOneInfo(int num) {
		System.out.println(num + "번 " + this.name + " " + this.score + "점");
	}
	
}

public class Test01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int N = 3;
		Student[] data = new Student[N];
		
		String name;
		int score;
		int input;
		int cnt = 0;
		
		while (true) {
			System.out.println("\n=== 학생부 프로그램 ===");
			System.out.println("1. 학생생성");
			System.out.println("2. 학생목록출력");
			System.out.println("3. 학생1명출력");
			System.out.println("4. 학생점수변경");
			System.out.println("5. 프로그램 종료");
			System.out.print("입력) ");
			int num = sc.nextInt();
			
			if (num == 1) {
				if (cnt == N) {
					System.out.println("\n학생을 " + N + "명 이상 생성할 수 없습니다.");
					continue;
				}
				System.out.print("\n학생이름입력) ");
				name = sc.next();
				System.out.print("학생점수입력) ");
				score = sc.nextInt();
				data[cnt] = new Student(name, score);
				data[cnt++].printInfo(cnt);
			} else if (num == 2) {
				int i = 1;
				System.out.println("\n== 학생목록 ==");
				for (Student stu : data) {
					if (stu == null) {
						if (i == 1) {
							System.out.println("출력할 학생 목록이 없습니다!");
						}
						break;
					}
					stu.printInfo(i++);
				}
			} else if (num == 3) {
				System.out.print("\n출력할 학생의 번호 입력) ");
				input = sc.nextInt();
				data[input - 1].printInfo(input);
			} else if (num == 4) {
				System.out.print("\n변경할 학생의 번호 입력) ");
				input = sc.nextInt();
				if (data[input - 1] == null) {
					System.out.println(input + "번 학생은 존재하지 않습니다.");
					continue;
				}
				System.out.print(data[input - 1].name + "의 점수입력) ");
				score = sc.nextInt();
				data[input - 1].score = score;
				System.out.println(data[input - 1].name + "의 점수변경완료!");
			} else if (num == 5) {
				System.out.println("\n프로그램이 종료됩니다...");
				break;
			}
		}
	}
}
