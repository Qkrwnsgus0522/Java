package class01;

import java.util.Random;
import java.util.Scanner;

// 369게임 1, 2번 풀이
public class Test03 {

	//	input : 정답과 사용자의 입력값을 알려주면
	//	output : 맞췄는지 틀렸는지를 반환
	public static boolean check(int num, String user) {
		final int NUM = num;
		int cnt = 0; // 배수의 개수
		int x = 1000;
		
		while (x > 0) {
			int n = num / x;
			if (n == 3 || n == 6 || n == 9) {
				cnt++;
			}
			num = num % x; // 1234 -> 234		
			x = x / 10;
		}
		
		String ans="";
		
		for(int i = 0; i < cnt; i++) {
			ans += "짝";
		}
		
		if(cnt == 0) {
			ans = Integer.toString(NUM);
		}

		System.out.println("ans: " + ans);
		System.out.println("user: " + user);

		if(ans.equals(user)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		// int num
		//	-> 1 ~ 1000 중에서 랜덤으로 정수 1개 생성
		// 1 ~ 1000 중에서 랜덤으로 정수 1개 생성
		// syso("[num] : ")
		// 사용자가 입력을 시도함
		//	-> String user
		// if (정답상황이라면,)
		//		sysout("정답")
		// else
		//		sysout("오답")
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int num = rand.nextInt(1000) + 1;
		System.out.print("[" +  num + "] : ");
		String user = sc.next();
		
		if(check(num, user)) {	// 정답상황이라면,
			System.out.println("정답입니다!");
		} else {
			System.out.println("오답입니다!");
		}
		
	}

}
