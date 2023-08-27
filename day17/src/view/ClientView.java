package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;
import model.ProductVO;

// 회원가입,로그인,로그아웃,마이페이지,회원탈퇴
// 목록출력,목록검색_이름,목록검색_가격
public class ClientView {
	private static Scanner sc=new Scanner(System.in);

	public int printClientMenu01() {
		System.out.println();
		System.out.println("=== 프 로 그 램 모 드 ===");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 프로그램 종료");
		System.out.print("입력) ");
		return sc.nextInt();
	}
	public MemberVO signUp() {
		System.out.println();
		System.out.println("=== 회 원 가 입 ===");
		System.out.print("아이디입력) ");
		String mid=sc.next();
		System.out.print("비밀번호입력) ");
		String mpw=sc.next();
		System.out.print("이름입력) ");
		String name=sc.next();
		return new MemberVO(mid,mpw,name);
	}
	public void signUpTrue() {
		System.out.println();
		System.out.println("회원가입 성공!");
	}
	public void signUpFalse() {
		System.out.println();
		System.out.println("회원가입 실패...");
	}
	public MemberVO signIn() {
		System.out.println();
		System.out.println("=== 로 그 인 ===");
		System.out.print("아이디입력) ");
		String mid=sc.next();
		System.out.print("비밀번호입력) ");
		String mpw=sc.next();
		return new MemberVO(mid,mpw,null);
	}
	public void signInTrue() {
		System.out.println();
		System.out.println("로그인 성공!");
	}
	public void signInFalse() {
		System.out.println();
		System.out.println("로그인 실패...");
	}
	public void printClientEnd01() {
		System.out.println();
		System.out.println("=== 프 로 그 램 종 료 ===");
	}
	
	public int printClientMenu02() {
		System.out.println();
		System.out.println("=== 사 용 자 모 드 ===");
		System.out.println("1. 로그아웃(사용자모드 종료)");
		System.out.println("2. 마이페이지"); //////////
		System.out.println("3. 회원탈퇴(사용자모드 종료)"); //////////
		System.out.println("4. 상품목록출력"); //////////
		System.out.println("5. 상품목록검색_이름으로 검색"); //////////
		System.out.println("6. 상품목록검색_가격으로 검색"); //////////
		System.out.print("입력) ");
		return sc.nextInt();
	}
	
	public String getSearchContent() {
		System.out.println();
		System.out.println("=== 이 름 으 로 검 색 ===");
		System.out.print("검색어입력) ");
		String name = sc.next();
		return name;
	}
	
	public int getSearchPriceContent() {
		System.out.println();
		System.out.println("=== 가 격 으 로 검 색 ===");
		System.out.println("1. 가장 비싼상품");
		System.out.println("2. 가장 싼상품");
		System.out.println("3. 해당금액보다 비싼상품");
		System.out.println("4. 해당금액보다 싼상품");
		System.out.println("5. 해당금액범위 상품");
		System.out.print("입력) ");
		return sc.nextInt();
	}
	
	public ProductVO getSearchPriceContent1() {
		System.out.println();
		System.out.println("=== 가 장 비 싼 상 품 ===");
		return new ProductVO(0, "expensive", 0, 0);
	}
	
	public ProductVO getSearchPriceContent2() {
		System.out.println();
		System.out.println("=== 가 장 싼 상 품 ===");
		return new ProductVO(0, "cheap", 0, 0);
	}
	
	public ProductVO getSearchPriceContent3() {
		System.out.println();
		System.out.println("=== 해 당 금 액 보 다 비 싼 상 품 ===");
		System.out.print("가격입력) ");
		int price = sc.nextInt();
		return new ProductVO(0, "expensive", price, 0);
	}
	
	public ProductVO getSearchPriceContent4() {
		System.out.println();
		System.out.println("=== 해 당 금 액 보 다 싼 상 품 ===");
		System.out.print("가격입력) ");
		int price = sc.nextInt();
		return new ProductVO(0, "cheap", price, 0);
	}
	
	public ProductVO getSearchPriceContent5() {
		System.out.println();
		System.out.println("=== 해 당 금 액 범 위 상 품 ===");
		System.out.print("최소가격입력) ");
		int minPrice = sc.nextInt();
		System.out.print("최대가격입력) ");
		int maxPrice = sc.nextInt();
		return new ProductVO(0, "filter", minPrice, maxPrice);
								// searchCondition
	}
	
	public void printProduct(ProductVO pVO) {
		System.out.println();
		if (pVO == null) {
			System.out.println("=== 출 력 할 상 품 없 음 ===");
			return;
		}
		System.out.println("=== 상 품 출 력 ===");
		System.out.println(pVO);
	}
	
	public void printProductList(ArrayList<ProductVO> pdatas) {
		System.out.println();
		if (pdatas.isEmpty()) { // 사용자 편의성 고려(UI/UX)
			System.out.println("=== 출 력 할 상 품 없 음 ===");
			return;
		}
		System.out.println("=== 목 록 출 력 ===");
		for(ProductVO data : pdatas) {
			System.out.println(data);
		}
	}
	
	public void logout() {
		System.out.println();
		System.out.println("=== 로 그 아 웃 ===");
	}
	public void printClientEnd02() {
		System.out.println();
		System.out.println("=== 사 용 자 모 드 종 료 ===");
	}
}
