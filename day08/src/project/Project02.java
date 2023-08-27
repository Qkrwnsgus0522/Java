package project;

import java.util.Scanner;

// 관리자 모드 비번 : 1234

// 학생부 클래스 선언
class Student2 {
	int num; // PK
	String name;
	int score;

	// 생성자
	Student2(int num, String name, int score) {
		this.num = num;
		this.name = name;
		this.score = score;

	}

	// 학생 목록 출력 메서드
	void printList() {
		System.out.println("=== 학생부 목록 ===");
		System.out.println(" | "+ this.name + " [" + this.score + "점]");
		System.out.println("==============");
	}

	// 학생 점수 변경
	void setScore(int score) {
		this.score = score;
		System.out.println( this.name + " 학생의 점수가 " + this.score + "점으로 업데이트 되었습니다!\n");
	}
}

//관리자 클래스 선언
class Admin {
	int num; // Pk
	String id;
	String pw;
	
	// 생성자
	Admin(int num, String id, String pw) {
		this.num = num;
		this.id = id;
		this.pw = pw;
	}
	
	//
	String getId() {
		return this.id;
	}
	
	String getPw() {
		return this.pw;
	}
	
	// 관리자 비밀번호 변경
	void setPw(String pw) {
		this.pw = pw;
	}
}

public class Project02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		final int N = 3;
		Student2[] data = new Student2[N]; // 학생 배열 객체 생성, 최대 3명
		Admin[] dataAd = new Admin[N]; // 관리자 배열 객체 생성, 최대 3명
		
		dataAd[0] = new Admin(1, "Admin01", "1234"); // 1번 관리자 생성
		
		// 사용자 메인화면
		String userMain = "=== 학생부 프로그램 ===\n"
				+ "1. 학생목록 출력\n"
				+ "2. 학생 1명 출력\n"
				+ "3. 프로그램 종료\n"
				+ "================\n "
				+ "\n"
				+ "번호 입력 : ";

		// 관리자 메인화면
		String managerMain = "=== 관리자 모드 ===\n"
				+ "1. 학생 생성\n"
				+ "2. 학생 점수 변경\n"
				+ "3. 관리자 생성\n"
				+ "4. 현재 관리자 비밀번호 변경\n"
				+ "5. 관리자 모드 종료\n"
				+ "6. 프로그램 종료\n"
				+ "==============\n "
				+ "\n"
				+ "번호 입력 : ";


		String name = ""; // 학생이름 받을 변수
		int score = 0; // 학생점수 받을 변수
		String adId = "";
		String adPw = "";
		int index = 0; // 학생목록에 저장되어있는 학생의 수
		int indexAd = 1; // 관리자목록에 저장되어있는 관리자의 수

		boolean flag = false;

		while (true) {

			System.out.println();
			System.out.print(userMain); // 사용자 메인화면 출력
			int action = sc.nextInt(); // 메인화면의 번호 입력받음

			// 3) 프로그램 종료
			if (action == 3) { 
				System.out.println("프로그램을 종료합니다...");
				flag = true;
				break;
			}

			// 1) 학생부 목록 출력
			else if (action == 1) { 
				if(index <= 0) { // 유효성 검사
					System.out.println("저장된 학생이 없습니다!");
					continue;
				}
				for (int i = 0; i < index; i++) {// 학생배열에 저장되어있는 학생만큼화면에 출력
					System.out.print((i + 1) + "번 학생");
					data[i].printList();
				}

			}

			// 2) 학생 1명 출력
			else if (action == 2) { 
				if(index <= 0) { // 유효성 검사
					// 학생 생성이 안되어있으면
					System.out.println("저장된 학생이 없습니다!");
					continue;
				}

				System.out.println("출력하고 싶은 학생의 번호를 입력하세요.");
				System.out.print("번호 입력 : ");
				
				int num = sc.nextInt(); // 출력할 학생 번호 입력

				if (num < 1 || num > index) { // 유효성 검사
					// 출력할 학생의 번호가 저장되어있는 학생 수 보다 크거나 음수이면
					System.out.println("해당 번호의 학생이 존재하지 않습니다!");
					continue;
				}
				System.out.print(num + "번 학생");
				data[num - 1].printList();
			}

			else if (action == 1234) { // 관리자 모드로 이동
				System.out.print("관리자 ID) ");
				adId = sc.next();
				System.out.print("관리자 PW) ");
				adPw = sc.next();
				
				int indexId = -1;
				String getPw = "";
				for (int i = 0; i < indexAd; i++) {
					if (adId.equals(dataAd[i].getId())) {
						indexId = i;
						getPw = dataAd[indexId].getPw();
					}
				}
				
				if (!adPw.equals(getPw)) {
					System.out.println("관리자 정보가 일치하지 않습니다.");
					continue;
				}
				
				System.out.println("관리자 모드로 이동합니다.");
				while (true) {
					System.out.println();
					System.out.print(managerMain);

					action = sc.nextInt(); // 관리자 메인화면의 번호 입력받음

					// 3) 관리자 모드 종료
					if (action == 5) { 					
						System.out.println("관리자 모드를 종료하겠습니다.");
						System.out.println("사용자 모드로 이동합니다.");
						break; // 사용자 모드로 이동
					}
					// 1) 학생 생성
					else if (action == 1) { 
						if (index >= data.length) { // 유효성 검사
							// 학생 배열의 이상으로 입력받으면
							System.out.println("정원이 초과되었습니다.");
						}
						while (index < data.length) {
							while (true) {
								System.out.println((index + 1) + "번 학생의 이름을 입력해주세요.");
								System.out.print("이름 입력 : ");
								name = sc.next();

								System.out.println("'"+ name + "' 학생을 등록하시겠습니까?");
								System.out.println("1) 네   2) 아니오");
								System.out.print("번호 입력 : ");
								action = sc.nextInt();

								if (action != 1) { // 유효성 검사
									// 아니오 또는 잘못된 입력이면
									System.out.println("다시 입력해주세요!");
									continue;
								}
								break;
							}

							while (true) {
								System.out.println("'"+ name + "' 학생의 점수를 입력해주세요.");
								System.out.print("점수 입력 : ");
								score = sc.nextInt();

								if (score < 0 || score > 100) { // 유효성 검사
									// 점수의 범위를 벗어난 입력이면
									System.out.println("0 ~ 100점으로 입력해주세요!");
									continue;
								}
								break;
							}
							// 학생 배열 객체에 저장
							System.out.println((index + 1) + "번 '" + name + "' 학생이 저장되었습니다!");
							data[index++] = new Student2(index, name, score);
							break;
						}

					}
					// 2) 학생 점수 변경
					else if (action == 2) {

						if (index <= 0) { // 유효성 검사
							// 학생이 생성이 안되어있으면
							System.out.println("저장된 학생이 없습니다!");
							continue;
						}

						while(true) {
							System.out.println("변경할 학생의 번호를 입력해주세요 : ");
							int stuNum = (sc.nextInt()) - 1;

							if (stuNum >= 0 && stuNum < index) {
								// 입력받은 학생 번호가 학생 생성된 인덱스 중에 있으면 점수 입력
								while (true) {
									System.out.println("몇 점으로 수정하시겠습니까?");
									System.out.print("점수 입력 : ");

									score = sc.nextInt();

									if (score > 100 || score < 0) { // 유효성 검사
										// 입력받은 점수가 100이상이거나 음수이면
										System.out.println("0 ~ 100점으로 입력해주세요!");
										continue;
									}
									else {
										break;
									}

								}
								data[stuNum].setScore(score);
								break;
							}
							else { // 유효성 검사
								// 입력받은 학생 번호가 학생 생성된 인덱스 중에 없으면
								System.out.println("해당 번호의 학생이 존재하지 않습니다!");
								System.out.println("다시 입력해주세요!");
								continue;
							}
						}

					}
					// 5) 관리자 생성
					else if(action == 3) {
						if (indexAd >= dataAd.length) { // 유효성 검사
							// 학생 배열의 이상으로 입력받으면
							System.out.println("관리자 정원이 초과되었습니다.");
						}
						while (indexAd < dataAd.length) {
							while (true) {
								while (true) {
									boolean flagId = false;
									System.out.println((indexAd + 1) + "번 관리자의 ID를 입력해주세요.");
									System.out.print("ID 입력 : ");
									adId = sc.next();
									for (int i = 0; i < indexAd; i++) {
										if (adId.equals(dataAd[i].getId())) {
											System.out.println("중복된 ID가 존재합니다!");
											System.out.println("다시 입력해주세요!");
											flagId = false;
											break;
										} else {
											flagId = true;
										}
									}
									if (flagId) {
										break;
									}
								}
								
								System.out.println("'"+ adId + "' 관리자를 등록하시겠습니까?");
								System.out.println("1) 네   2) 아니오");
								System.out.print("번호 입력 : ");
								action = sc.nextInt();

								if (action != 1) { // 유효성 검사
									// 아니오 또는 잘못된 입력이면
									System.out.println("다시 입력해주세요!");
									continue;
								}
								break;
							}

							while (true) {
								System.out.println("'"+ adId + "' 관리자의 PW를 입력해주세요.");
								System.out.print("PW 입력 : ");
								adPw = sc.next();
								System.out.println("이 비밀번호로 '"+ adId + "' 관리자를 등록하시겠습니까?");
								System.out.println("1) 네   2) 아니오");
								System.out.print("번호 입력 : ");
								action = sc.nextInt();
								
								if (action != 1) { // 유효성 검사
									// 아니오 또는 잘못된 입력이면
									System.out.println("다시 입력해주세요!");
									continue;
								}
								break;
							}
							// 학생 배열 객체에 저장
							System.out.println((indexAd + 1) + "번 '" + adId + "' 관리자가 저장되었습니다!");
							dataAd[indexAd++] = new Admin(indexAd, adId, adPw);
							break;
						}
					}
					// 6) 현재 관리자 비밀번호 변경
					else if(action == 4) {
						System.out.print("현재 비밀번호 입력) ");
						adPw = sc.next();
						
						if (!adPw.equals(dataAd[indexId].getPw())) {
							System.out.println("현재 비밀번호가 일치하지 않습니다!");
							continue;
						}
						
						System.out.print("변경할 비밀번호 입력) ");
						adPw = sc.next();
						System.out.print("변경할 비밀번호 확인입력) ");
						String adPw2 = sc.next();
						
						if (!adPw.equals(adPw2)) {
							System.out.println("변경할 비밀번호가 일치하지 않습니다!");
							continue;
						}
						
						System.out.println("이 비밀번호로 변경하시겠습니까?");
						System.out.println("1) 네   2) 아니오");
						System.out.print("번호 입력 : ");
						action = sc.nextInt();
						
						if (action != 1) { // 유효성 검사
							System.out.println("비밀번호 변경을 취소합니다.");
							continue;
						}
						
						System.out.println("'" + dataAd[indexId].getId() + "' 관리자 비밀번호가 변경되었습니다!");
						dataAd[indexId].setPw(adPw);
					}
					// 4) 프로그램 완전 종료
					else if(action == 6) {
						System.out.println("프로그램을 종료합니다...");
						flag = true;
						break;
					}
					else { // 유효성 검사
						// 관리자 메인화면의 번호를 잘못 입력했으면
						System.out.println("잘못 입력하셨습니다!");
						System.out.println("다시 입력해주세요!");
					}
				}
			}
			else { // 유효성 검사
				// 사용자 메인화면의 번호를 잘못 입력했으면
				System.out.println("잘못 입력하셨습니다!");
				System.out.println("다시 입력해주세요!");
			}
			if(flag) {
				break; // 프로그램 완전 종료
			}
		}
	}
}