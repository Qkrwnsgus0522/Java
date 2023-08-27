package class04;

import java.util.Random;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		int N = 4; // 상품이 4개란 뜻
		// 상품 이름
		String[] mName = new String[N];
//		mName[0] = "아메리카노";
//		mName[1] = "카페라떼";
//		mName[2] = "아이스티";
//		mName[3] = "프라푸치노";
		for (int i = 0; i < mName.length; i++) {
			System.out.print((i + 1) + "번 상품이름 입력: ");
			mName[i] = sc.nextLine();
			System.out.println(mName[i] + " 상품 저장완료!");
			System.out.println();
		}

		// 상품 가격
		int[] mPrice = new int[N];
//		for (int i = 0; i < mPrice.length; i++) {
//			mPrice[i] = (rand.nextInt(6) + 10) * 100;
//			// 10 ~ 15 X 100 : 연산자 우선순위 이슈 체크!
//		}
		for (int i = 0; i < mPrice.length; i++) {
			System.out.print(mName[i] + "의 가격 입력: ");
			mPrice[i] = sc.nextInt();
			System.out.println();
		}
		System.out.println();
		// 상품 재고
		int[] mCnt = new int[N];
//		for (int i = 0; i < mCnt.length; i++) {
//			mCnt[i] = rand.nextInt(4); // 0 ~ 3
//		}
		for (int i = 0; i < mCnt.length; i++) {
			System.out.print(mName[i] + "의 개수 입력: ");
			mCnt[i] = sc.nextInt();
			System.out.println();
		}
		
		while (true) {
			System.out.println("1. 구매 2. 종료");
			System.out.print("입력) ");
			int action = sc.nextInt();
			if (action == 2) {
				System.out.println("프로그램 종료...");
				System.out.println();
				break;
			} else if (action < 1 || 2 < action) {
				System.out.println("유효하지않은 값입니다!");
				System.out.println("다시입력해주세요!");
				continue;
			}
			while (true) {
				System.out.println(" === 메뉴목록 === ");
				for (int i = 0; i < mName.length; i++) {
					System.out.print((i + 1) + ". " + mName[i] + "[");
					if (mCnt[i] == 0) {
						System.out.print("재고없음");
					} else {
						System.out.print(mCnt[i]);
					}
					System.out.println("]");
				}
				System.out.println("===================");
				System.out.print("번호입력) ");
				int num = sc.nextInt();
				
				// 1 ~ 4 사이이고, 재고도 있어야함!
				if ((1 <= num && num <= N) && (mCnt[num - 1] > 0)) {
					break;
				}
				if (num < 1 || N < num) {
					System.out.println("없는 상품입니다.");
				} else if (mCnt[num - 1] == 0) {
					System.out.println("재고가 없어서 구매가 불가능합니다.");
				}
			}
			
			System.out.println("몇개?");
			System.out.println("돈?");
		}
		
	}

}
