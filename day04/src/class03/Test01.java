package class03;

import java.util.Random;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int N = 4; // 상품 개수
		String[] mName = new String[N]; // 상품 이름
//		mName[0] = "사이다";
//		mName[1] = "콜라";
//		mName[2] = "환타";
//		mName[3] = "웰치스";
		
		int[] mPrice = new int[N]; // 상품 가격
//		for (int i = 0; i < mPrice.length; i++) {
//			mPrice[i] = rand.nextInt(2000) + 2000;
//		}
		
		int[] mCnt = new int[N]; // 상품 재고
//		for (int i = 0; i < mCnt.length; i++) {
//			mCnt[i] = rand.nextInt(10) + 1;
//		}
		
		// 0. 상품 정보 입력
		for (int i = 0; i < N; i++) {
			System.out.print((i + 1) + "번째 상품 이름을 입력해주세요) ");
			String inName = sc.next();
			mName[i] = inName;
			System.out.print(mName[i] + "의 상품 가격을 입력해주세요) "); // 입력 자료형 유효성
			int inPrice = sc.nextInt();
			mPrice[i] = inPrice;
			System.out.print(mName[i] + "의 상품 재고를 입력해주세요) "); // 입력 자료형 유효성
			int inCnt = sc.nextInt();
			mCnt[i] = inCnt;
		}
		
		while (true) {
			// 1. 구매, 종료
			System.out.println("1- 구매 2- 종료");
			System.out.print("입력) ");
			int action = sc.nextInt();
			if (action == 2) { // 2를 입력한 경우
				System.out.println("구매를 종료합니다.");
				break;
			} else if (action < 1 || 2 < action) { // 범위 내 값을 입력하지 않은 경우
				System.out.println("잘못된 입력값입니다.");
				System.out.println("확인 후 다시 이용해주세요.");
				System.out.println();
				continue;
			}
			
			int num;
			while (true) {
				// 2. 상품 출력
				System.out.println("=== 메뉴판 ===");
				for (int i = 0; i < N; i++) {
					System.out.println((i + 1) + ". " + mName[i] + " [" + (mCnt[i] == 0 ? "재고없음" : mCnt[i]) + "]");
				}
				System.out.println("=============");
				
				// 3. 구매 상품 입력
				System.out.print("구매할 상품의 번호를 입력해주세요) ");
				num = sc.nextInt();
				if (0 < num && num <= N) { // 범위 내 상품을 입력한 경우
					if (mCnt[num - 1] != 0) {
						break;
					} else {
						System.out.println("재고가 없어서 구매가 불가능합니다!");
						System.out.println("다른 상품을 입력해주세요.");
						continue;
					}
				}
				System.out.println("없는 상품입니다!");
				System.out.println("확인 후 다시 입력해주세요.");
				System.out.println();
			}
			
			int cnt;
			boolean flag = false;
			while (true) {
				// 3. 구매 상품 수량 입력
				System.out.println("선택한 상품은 " + num + "번 " + mName[num - 1] + "입니다.");
				System.out.println("가격: " + mPrice[num - 1] + "원  재고: " + mCnt[num - 1] + "개");
				System.out.print("구매할 개수를 입력해주세요) ");
				cnt = sc.nextInt();
				
				if (cnt == 0) { // 0개 구매할 시
					flag = true;
					break;
				} else if (0 <cnt && cnt <= mCnt[num -1]) { // 범위 내 수량을 입력한 경우
					break;
				}
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요");
				System.out.println();
			}
			if (flag) {
				System.out.println("상품 구매를 취소하였습니다.");
				System.out.println("처음으로 돌아갑니다");
				continue;
			}
			
			// 4. 구매 금액
			int res = mPrice[num - 1] * cnt;
			int money;
			System.out.println("금액: " + res + "원");
			while (true) {
				System.out.print("돈 입력) ");
				money = sc.nextInt();
				if (res <= money) {
					break;
				}
				System.out.println("잘못된 입력입니다.");
				System.out.println("새로 입력해주세요");
				System.out.println();
			}
			
			res = money - res;
			if (res != 0) {
				System.out.println("거스름돈 " + res + "원 반환 완료!");
			}
			System.out.println("구매 성공!");
			System.out.println();
			
			mCnt[num - 1] -= cnt;
		}
	}
}
