package project;

import java.util.Scanner;

// 학생부 클래스 선언
class Student {
	int num; // PK
	String name;
	int score;

	// 생성자
	Student(int num, String name, int score) {
		this.num = num;
		this.name = name;
		this.score = score;

	}

	// 학
	void saveStu(String name, int score) {
		this.name = name;
		this.score = score;

	}

	// 목록 출력 메소드)
	void printList() {
		System.out.println(" | " + this.name + "  [" + this.score + "점]\n");
	}

	void setScore(int score) {
		this.score = score;
		System.out.println( this.name + " 학생의 점수가 " + this.score + "점으로 변경되었습니다.\n");
	}
}

public class Project01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int N = 3; // 객체배열크기
		String msg; // 메뉴 목록
		Student[] data = new Student[N]; // 학생 리스트 최대 N명까지
		Admin[] dataA = new Admin[N]; // 관리자 리스트 최대 N명까지
		dataA[0] = new Admin(1, "Admin01", "1234"); // 1번 관리자 생성
		String name = ""; // 학생이름 받을 변수
		int score = 0; // 학생점수 받을 변수
		int index = 0; // 학생목록에 저장되어있는 학생의 수
		int indexAd = 1; // 관리자목록에 저장되어있는 관리자의 수
		
		boolean flag = false;

		while (true) {
			msg = "=== 학생부 프로그램 ===\n"
					+ "1. 학생목록 출력\n"
					+ "2. 학생 1명 출력\n"
					+ "3. 프로그램 종료\n"
					+ "====================\n "
					+ "\n"
					+ "번호를 입력하세요 : ";
			System.out.println();
			System.out.print(msg); // 학생부 프로그램 메시지 (1. 학생생성 2. 핵생목록출력 3. 학생 1명 출력 4. 학생점수 변경 5. 프로그램 종료)
			int action = sc.nextInt();


			if (action == 3) { // 3) 프로그램 종료
				System.out.println("프로그램을 종료합니다...");
				flag =true;
				break;
			}

			else if (action == 1) { // Read 먼저 구현했는뎅
				// 학생배열에 저장되어있는 학생만큼 화면에 출력해줘
				if(index <= 0) {
					System.out.println("저장된 학생이 없습니다!");
					continue;
				}
				for (int i = 0; i < index; i++) {// 학생배열에 저장되어있는 학생의 개수 ==>> 변수로 들고있었어야 함
					System.out.print((i + 1) + "번 학생");// +data[i].학생출력()); //
					data[i].printList();
				}

			}

			else if (action == 2) { // 학생 1명 출력
				if(index <= 0) {
					System.out.println("저장된 학생이 없습니다!");
					continue;
				}

				System.out.print("출력하고 싶은 학생의 번호를 입력하세요 : ");
				int num = sc.nextInt(); // 출력할 학생 번호입력

				if (num < 1 || num > index) { // 출력할 학생의 번호가 저장되어있는 학생 개수 보다 크면
					System.out.println(num + "번 학생은 존재하지 않습니다.");
					continue;
				}
				System.out.print(num + "번 학생");
				data[num - 1].printList();
			}

			else if (action == 1234) { // 관리자 모드로 이동
				System.out.println("관리자 모드로 이동합니다.");
				while (true) {
					msg = "=== 관리자 모드 ===\n"
							+ "1. 학생 생성\n"
							+ "2. 학생 점수 변경\n"
							+ "3. 관리자 계정 추가\n"
							+ "4. 관리자 비밀번호 변경\n"
							+ "5. 관리자 모드 종료\n"
							+ "6. 프로그램 종료\n"
							+ "==================\n "
							+ "\n"
							+ "번호를 입력하세요 : ";
					
					System.out.println();
					System.out.print(msg);

					action = sc.nextInt();
					if (action == 5) { // 사용자 모드로 이동
						System.out.println("사용자 모드로 이동합니다.");
						break;
					} else if (action == 1) { // Create 학생 생성
						// 상품 객체를 생성해서
						if (index >= data.length) {
							System.out.println("정원초과");
						}
						while (index < data.length) {
							while (true) {
								System.out.println((index + 1) + "번학생 이름입력) ");
								name = sc.next();
								System.out.println("맞는이름이니? Yes: 1 , No: 2");
								action = sc.nextInt();
								if (action != 1) {
									System.out.println("다시입력해주세요");
									continue;
								}
								break;
							}

							while (true) {
								System.out.println((index + 1) + "번학생점수입력)");
								score = sc.nextInt();
								// 점수입력이 음수일때 방지
								if (score < 0 || score > 100) {
									System.out.println("100점이하 ~ 0점이상으로 입력하세요");
									continue;
								}
								break;
							}
							System.out.println((index + 1) + "번" + name + "학생 생성 완료)");
							// 상품 객체 배열에 저장해줘~
							data[index++] = new Student(index, name, score);// 현재위치//생성자를 한개이상 구현 해 놓았기 때문에 디폴트생성자는
							// 기본제공이 안됨
							break;
						}

					} else if (action == 2) { // 학생점수 변경
						if (index < 0) {
							System.out.println("저장된 학생이 없습니다");
							continue;
						}

						System.out.println("변경할 학생 번호) ");
						int stuNum = (sc.nextInt()) - 1;

						if (stuNum >= 0 && stuNum < index) {
							while (true) {
								System.out.println("몇점으로 수정하시겠습니까?");
								score = sc.nextInt();

								if (score > 100 || score < 0) {
									System.out.println("잘못된 점수입니다");
									continue;
								} else {
									break;
								}

							}
							data[stuNum].setScore(score);
						} else {
							System.out.println("존재하지 않는 번호입니다");
							continue;
						}
					} else if (action == 3) { // 관리자 계정 추가
						if (indexAd >= dataA.length) {
							System.out.println("정원초과");
							continue;
						}
						while (true) {
							System.out.println((indexAd + 1) + "번관리자 이름입력) ");
							name = sc.next();
							System.out.println("맞는이름이니? Yes: 1 , No: 2");
							action = sc.nextInt();
							if (action != 1) {
								System.out.println("다시입력해주세요");
								continue;
							}
							break;
						}
						while (true) {
							System.out.println((indexAd + 1) + "번학생점수입력)");
							score = sc.nextInt();
							// 점수입력이 음수일때 방지
							if (score < 0 || score > 100) {
								System.out.println("100점이하 ~ 0점이상으로 입력하세요");
								continue;
							}
							break;
						}
						System.out.println((index + 1) + "번" + name + "학생 생성 완료)");
						// 상품 객체 배열에 저장해줘~
						data[index++] = new Student(index, name, score);
						
					} else if (action == 4) { // 관리자 비밀번호 변경

					} else if (action == 6) { // 프로그램 종료
						System.out.println("프로그램 종료합니다.");
						flag = true;
						break;
					} else {
						System.out.println("올바르게 입력해 주세요");
					}

				}
			}

			else {
				System.out.println("올바르게 입력해 주세요");
			}
			if(flag) {
				break;
			}
		}
	}
}
		