package class07;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
	/*
	★★
	1의 게임을 3번 할건데,
	3번 다 정답이면 이름을 입력받아서
	ㅁㅁㅁ님 축하합니다!~~ 상품드리겠습니다!~~~
	[19] : 짝
	정답입니다!
	[19] : 19
	오답입니다.....
	- 끝 -
	
	[19] : 짝
	정답입니다!
	[19] : 짝
	정답입니다!
	[19] : 짝
	정답입니다!
	이름입력) 김효경
	김효경님 축하합니다!~~~ 상품드리겠습니다!~~~
	 */
	
	//	while(최대 3번) {
	//		[1번코드]
	//		if(틀렸다면) {
	//			break;
	//		}
	//	}
	
	// 	if(3번 다 정답이니?) {
	//		이름을 입력받을 경우
	//		이름 출력
	// 	}
	
	public static boolean check(int num, String user) {
		final int NUM = num;
		// final : 상수화
		
		int cnt = 0; // 박수 횟수 카운트 할 변수
		
		// 1. 진짜 정답을 만들기 String ans
		
		int n = num / 1000; // 1000인 경우, 1을 의미함
		if (n == 3 || n == 6 || n == 9) {
			cnt++;
		}
		
		num = num % 1000; // 1312인 경우, 13을 의미하게 되므로 전처리가 필수!
		n = num / 100; // 1312 -> 312, 3을 의미함
		if (n == 3 || n == 6 || n == 9) {
			cnt++;
		}
		
		num = num % 100;
		n = num / 10;
		if (n == 3 || n == 6 || n == 9) {
			cnt++;
		}
		
		num = num % 10;
		n = num / 1;
		if (n == 3 || n == 6 || n == 9) {
			cnt++;
		}
		
		////////////////////////////////////////
		
		String ans = "";
		for (int i = 0; i < cnt; i++) {
			ans += "짝";
		}
		if(cnt == 0) {
			// 형변환(casting)
			ans = Integer.toString(NUM);
		}
		System.out.println("ans : " + ans);
		
		
		// 2. ans와 user를 비교
		System.out.println("ans : " + ans);
		System.out.println("user : " + user);
		if (ans.equals(user)) {
			return true;
		}
		
		return false;
		// 연산자는 기본 자료형(원시타입)에게만 적용되는 문법
		// ex) int, double, char, float
		// 클래스(객체)들은 연산자로 비교 불가능
	}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		// 1 ~ 1000 중에서 랜덤으로 정수 1개 생성
		// int ranNum
		// [randNum] : 출력
		// 사용자가 정답을 입력 : 짝, 19, 22
		// String userAns = sc.next();
		// if(정답)
		//	sysout("정답!");
		// else
		//	sysout("오답...");
		
		int i = 0;
		while(i < 3) {

			int randNum = rand.nextInt(1000) + 1;
			System.out.print("[" + randNum + "] : ");
			String userAns = sc.next();
			
			if (!check(randNum, userAns)) {
				System.out.println("오답입니다.");
				break;
			}
			System.out.println("정답입니다.");
			i++;
		}
	}
}
