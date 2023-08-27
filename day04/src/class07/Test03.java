package class07;

import java.util.Random;

public class Test03 {

	public static void test() { // "메서드 시그니처"
		
		Random rand = new Random();
		int num = rand.nextInt(11) + 10;
		System.out.println("랜덤수 : " + num);
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("총합 : " + sum);
	}
	
	public static int test2(int num) {
		
		int cnt = 0;
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static int test22(int a, int b) {
		
		int cnt = 0;
		for (int i = a; i <= b; i++) {
			if (i % 2 == 0) {
				cnt++;
			}
		}
		return cnt;
	}

	
	public static String test3(int num) {
		
		String str = "banana";
		if (num > 10) {
			str = "apple";
		}
		return str;
	}
	
	public static void main(String[] args) {
		
		int n = 11;
		test();
		int cnt = test2(n);
		System.out.println(cnt);
		System.out.println(test3(n));
		System.out.println(test22(2, 5));
	}

}
