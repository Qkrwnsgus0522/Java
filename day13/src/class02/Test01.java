package class02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			try {
				System.out.print("정수입력) ");
				int num = sc.nextInt();
				System.out.println("num= " + num);			
			} catch (InputMismatchException e) {
				sc.nextLine(); // 버퍼에 남아있는 쓰레기값을 제거하는 코드
				System.out.println("정수로만 입력하셔야합니다");
			}
		}
	}
}
