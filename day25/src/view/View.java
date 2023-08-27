package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MovieVO;

public class View {
	
	private static Scanner sc = new Scanner(System.in);
	
	public int tryCatchInt() {
		int num = 0;
		while (true) {
			try {
				System.out.print("번호입력) ");
				num = sc.nextInt();
				if (num < 0) {
					System.out.println("\n올바른 숫자를 입력하세요.");
					continue;
				}
				return num;
			} catch(Exception e) {
				System.out.println("\n정수를 입력해주세요.");
				sc.nextLine();
			}			
		}
	}
	
	public int tryCatchMenu(int minNum, int maxNum) {
		int num = 0;
		while (true) {
			try {
				System.out.print("번호입력) ");
				num = sc.nextInt();
				if (num < minNum || maxNum < num) {
					System.out.println("\n올바른 숫자를 입력하세요.");
					continue;
				}
				return num;
			} catch(Exception e) {
				System.out.println("\n정수를 입력해주세요.");
				sc.nextLine();
			}			
		}		
	}
	
	public void printMenu() {
		System.out.println("\n영화 프로그램입니다.");
		System.out.println("샘플 데이터를 크롤링합니다...");
	}
		
	public void printTrue() {
		System.out.println("\n작업 성공!");
	}
	
	public void printFalse() {
		System.out.println("\n작업 실패...");
	}
	
	public int printUserMenu() {
		System.out.println("\n=== 메뉴 ===");
		System.out.println("1. 영화검색");
		System.out.println("2. 영화삭제");
		System.out.println("3. 영화변경");
		System.out.println("4. 영화목록출력");
		System.out.println("5. 프로그램종료\n");
		int minNum = 1;
		int maxNum = 5;
		return tryCatchMenu(minNum, maxNum);
	}
	
	public int printUserMenu1() {
		System.out.println("\n1. 영화번호로 검색");
		System.out.println("2. 영화제목으로 검색");
		int minNum = 1;
		int maxNum = 2;
		return tryCatchMenu(minNum, maxNum);
	}
	
	public int printUserMenu2() {
		System.out.println("\n삭제할 영화번호를 입력해주세요.");
		return tryCatchInt();
	}
	
	public int getCheckDelete() {
		System.out.println("\n삭제하시겠습니까?");
		System.out.println("1. YES	2. NO");
		int minNum = 1;
		int maxNum = 2;
		return tryCatchMenu(minNum, maxNum);
	}
	
	public void printDeleteCancel() {
		System.out.println("삭제를 취소하였습니다.");
	}
	
	public void printDeleteTrue() {
		System.out.println("\n삭제 성공!");
	}
	
	public void printDeleteFalse() {
		System.out.println("\n삭제 실패...");
	}
	
	public int printUserMenu3() {
		System.out.println("\n변경할 영화번호를 입력해주세요.");
		return tryCatchInt();
	}
	
	public int getUpdateType() {
		System.out.println("\n변경할 방식을 선택해주세요");
		System.out.println("1. 영화제목변경");
		System.out.println("2. 영화날짜변경\n");
		int minNum = 1;
		int maxNum = 2;
		return tryCatchMenu(minNum, maxNum);
	}
	
	public int getMovieNum() {
		System.out.println("\n영화번호을(를) 입력해주세요.");
		return tryCatchInt();
	}
	
	public String getMovieName() {
		System.out.println("\n영화제목을(를) 입력해주세요.");
		System.out.print("제목입력) ");
		return sc.next();
	}
	
	public String getMovieOdate() {
		System.out.println("\n개봉날짜을(를) 입력해주세요.");
		System.out.println("입력방식 - YYYY.MM.DD");
		System.out.print("날짜입력) ");
		return sc.next();
	}
	
	public void printUpdateTrue() {
		System.out.println("\n변경 성공!");
	}
	
	public void printUpdateFalse() {
		System.out.println("\n변경 실패...");
	}
	
	public void printExistsFalse() {
		System.out.println("\n해당번호는 존재하지않습니다...");
	}
	
	public void printExitProgram() {
		System.out.println("\n프로그램을 종료합니다.");
	}
	
	public void printMovieList(ArrayList<MovieVO> mdatas) {
		System.out.println("=== 영화 목록 ===");
		for(MovieVO mdata : mdatas) {
			System.out.println(mdata);
		}
	}
	
	public void printMovie(MovieVO mdata) {
		System.out.println("=== 영화 정보 ===");
		System.out.println(mdata);
	}
	
}
