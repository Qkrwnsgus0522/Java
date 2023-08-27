package class02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> data1 = new HashSet<Integer>();
		
		for (int i = 0; i < 10; i++) {
			data1.add(rand.nextInt(15) + 1);
		}
		
		System.out.println("랜덤수는 " + data1.size() + "개 생성되었고,\n" + data1 + " 입니다.");
		
		ArrayList<Integer> data2 = new ArrayList<Integer>();
		HashSet<Integer> data2Even = new HashSet<Integer>();
		
		
		int sum = 0;
		double avg = 0;
		
		while (true) {
			System.out.print("정수 입력) ");
			int action = sc.nextInt();
			if (action == 0) {
				avg = sum * 1.0 / data2.size();
				System.out.println("평균은 " + avg + "입니다.");
				for (int i : data2) {
					if (i % 2 == 0) {
						data2Even.add(i);
					}
				}
				ArrayList<Integer> data2Sort = new ArrayList<Integer>(data2Even); // HashSet -> ArrayList 변경
				Collections.sort(data2Sort); // ArrayList 정렬
				System.out.println("짝수는 " + data2Sort.size() + "개 입니다.\n" + data2Sort + "입니다.");
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				data2.add(action);
				sum += action;
			}
		}
	}

}
