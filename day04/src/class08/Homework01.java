package class08;

import java.util.Scanner;

public class Homework01 {

	public static boolean even(int num) {
		boolean flag = false;
		if (num % 2 == 0) {
			flag = true;
		}
		return flag;
	}
	
	public static boolean nag(int num) {
		boolean flag = false;
		if (num < 0) {
			flag = true;
		}
		return flag;
	}
	
	public static boolean zero(int num) {
		boolean flag = false;
		if (num == 0) {
			flag = true;
		}
		return flag;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int cnt = 0;
		int a = 0;
		int b = 0;
		System.out.println("정수를 10번 입력해주세요");
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + ") ");
			num = sc.nextInt();
			cnt++;
			if (zero(num)) {
				break;
			}
			if (even(num)) {
				a++;
			}
			if (nag(num)) {
				b++;
			}
		}
		System.out.println(cnt + "번 입력완료했습니다. a=" + a + " b=" + b + " 입니다.");
	}

}
