package class04;

import java.util.Random;
import java.util.Scanner;

public class Test01 {

	public static int cntMul(int num) {
		int mCnt = 0;
		int i = 0;
		while (true) {
			if (num == 0) { // num이 0일때
				break;
			}
			i = num % 10;
			if (i % 3 == 0 && i != 0) { // 3의 배수 확인
				mCnt++;
			}
			num /= 10;
		}
		return mCnt;
	}
	
	public static String ansStr(int mCnt, int num) {
		String ans = "";
		if (mCnt == 0) {
			ans = String.valueOf(num);
		}
		for (int i = 0; i < mCnt; i++) {
			ans += "짝";
		}
		return ans;
	}
	
	public static void addRank(String[] arr, int arrCnt) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력) ");
		String str = sc.nextLine();
		System.out.println(str + "님 축하합니다!~~ 상품드리겠습니다!~~");
		arr[arrCnt] = str;
	}
	
	public static void printRank(String[] arr) {
		System.out.println("명예의 전당");
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			System.out.println((i + 1) + ". " + arr[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		String[] arr = new String[5];
		int arrCnt = 0;
		
		while (true) {
			int cnt = 0;
			int temp = 0;
			while (cnt < 3) {
				int mCnt = 0;
				String ans = "";
				int num = rand.nextInt(1000) + 1;
				mCnt = cntMul(num);
				ans = ansStr(mCnt, num);
				System.out.print("[" + num + "] : ");
				String str = sc.nextLine();
				if (str.equals(ans)) {
					System.out.println("정답입니다!");
				} else {
					System.out.println("오답입니다...");
					System.out.println("- 끝 -");
					cnt = 0;
					continue;
				}
				cnt++;
			}
			if (cnt == 3) {
				addRank(arr, arrCnt);
				arrCnt++;
			}
			printRank(arr);
			if (arrCnt == 5) {
				break;				
			}
		}
		
	}
}
