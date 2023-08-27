package class02;

import java.util.Random;
import java.util.Scanner;

// 369게임 1, 2번 풀이
public class Test01 {

	//	input : 정답과 사용자의 입력값을 알려주면
	//	output : 맞췄는지 틀렸는지를 반환
	public static boolean check(int num, String user) {
		final int NUM = num;
		int cnt = 0; // 짝수의 개수
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
		for(int i=0;i<cnt;i++) {
			ans+="짝";
		}
		if(cnt==0) {
			ans=Integer.toString(NUM);
		}

		System.out.println("ans: "+ans);
		System.out.println("user: "+user);

		if(ans.equals(user)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		// while(3번)
		//		[1]
		//		if(오답이라면) -> 종료조건
		//			break;
		// if(3번 다 정답이야?)
		//		이름 입력
		//		입력받은 이름을 출력
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		final int LV = 3; 
		int i = 0;
		while(i < LV) {
			int num = rand.nextInt(1000) + 1;
			System.out.print("[" +  num + "] : ");
			String user = sc.next();
			
			if(!check(num, user)) {	// 오답상황이라면,
				System.out.println("오답입니다!");
				break;
			} else {
				System.out.println("정답입니다!");
			}
			i++;
		}
		
		if (i == LV) {
			System.out.print("이름입력) ");
			String name = sc.next();
			System.out.println(name + "님 축하합니다!~~");
		}
		
	}

}
