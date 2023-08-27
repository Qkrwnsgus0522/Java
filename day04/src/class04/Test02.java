package class04;

import java.util.Random;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		int N = 4; // 상품이 4개란 뜻
		// 상품 이름
		String[] mName = new String[N];
		int index = 0;
		while (true) {
			if (index == N) {
				break;
			}
			System.out.print((index + 1) + "번 상품이름 입력: ");
			mName[index] = sc.nextLine(); // 문자열 입력
			System.out.println(mName[index] + " 이(가) 맞나요?");
			System.out.print("1-YES 2-NO : ");
			int ans = sc.nextInt();
			sc.nextLine(); // 버퍼에 남아있는 쓸데없는 값들을 지워주는 코드
			
			if (ans != 1) {
				System.out.println("다시 입력해주세요!");
				continue;
			}
			
			System.out.println();
			
			index++;
		}

		// 상품 가격
		int[] mPrice = new int[N];
		for (int i = 0; i < mPrice.length; i++) {
			System.out.print(mName[i] + "의 가격 입력: ");
			mPrice[i] = sc.nextInt();
			System.out.println();
		}
		
		// 상품 재고
		int[] mCnt = new int[N];
		for (int i = 0; i < mCnt.length; i++) {
			System.out.print(mName[i] + "의 개수 입력: ");
			mCnt[i] = sc.nextInt();
			System.out.println();
		}

	}

}
