package class02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 정상적인 입력을 3번할때까지 계속
		for (int i = 0; i < 3; i++) {
			try {
				System.out.print("정수입력) ");
				int num = sc.nextInt();
				System.out.println("num= " + num);				
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수로만 입력해주세요.");
				i--;
			}
		}
		
		// 정상적인 입력을 3번할때까지 계속 
		int cnt = 0;
		while (cnt < 3) {
			try {
				System.out.print("정수입력) ");
				int num = sc.nextInt();
				System.out.println("num= " + num);
				cnt++;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수로만 입력해주세요.");
			}
		}

	}

}
