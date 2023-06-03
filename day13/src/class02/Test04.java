package class02;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> data = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		final int CNT = 3;
//		for (int i = 0; i < CNT; i++) {
//			System.out.print("정수입력) ");
//			int num = sc.nextInt();
//			data.add(num);
//		}
		while (data.size() < CNT) {
			int num;
			try {
				System.out.print("정수입력) ");
				num = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수로만 입력해주세요.");
				continue;
			}
			data.add(num);
		}
		System.out.println(data);
		
		int i = 0;
		while (i < data.size()) {
			if (data.get(i) <= 0) {
				data.remove(i);
				continue;
			}
			i++;
		}
		System.out.println(data);
		
		int maxIndex = 0;
		int max = data.get(0);
		for (int j = 1; j < data.size(); j++) {
			if (data.get(j) > max) {
				max = data.get(j);
				maxIndex = j;
			}
		}
		System.out.println("최대값= " + max);
		System.out.println("인덱스= " + maxIndex);
		data.remove(maxIndex);
		
		int sum = 0;
		for (int v : data) {
			sum += v;
		}
		double avg = sum * 1.0 / data.size();
		System.out.println("총합= " + sum);
		System.out.println("평균= " + avg);
	}
	
}
